package com.shrtcut.shrtcut.service;

import com.shrtcut.shrtcut.dto.UrlRequestDto;
import com.shrtcut.shrtcut.dto.UrlResponseDto;
import com.shrtcut.shrtcut.exception.ShortUrlAlreadyExistsException;
import com.shrtcut.shrtcut.model.UrlMapping;
import com.shrtcut.shrtcut.repository.UrlRepository;
import com.shrtcut.shrtcut.util.ShortCodeGenerator;
import com.shrtcut.shrtcut.util.UrlMapper;
import org.springframework.cache.annotation.Cacheable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class UrlService {
    private final UrlRepository urlRepository;
    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }


    public UrlResponseDto shortenUrlWithCustomCode(UrlRequestDto urlRequestDto) {
        String customShortCode = urlRequestDto.getShortCode();
        if (urlRepository.findByShortCode(customShortCode).isPresent()) {
            throw new ShortUrlAlreadyExistsException("Short URL already exists");
        }

        UrlMapping urlMapping = new UrlMapping();
        urlMapping.setLongUrl(urlRequestDto.getLongUrl());
        urlMapping.setShortCode(customShortCode);
        urlMapping.setCreatedAt(LocalDateTime.now());

        urlRepository.save(urlMapping);
        return UrlMapper.toDto(urlMapping);
    }

    public UrlResponseDto shortenUrlWithRandomCode(String longUrl) {
        Optional<UrlMapping> existing = urlRepository.findByLongUrl(longUrl);
        if (existing.isPresent()) {
            return UrlMapper.toDto(existing.get());
        }

        String shortCode = ShortCodeGenerator.generate();
        while (urlRepository.findByShortCode(shortCode).isPresent()) {
            shortCode = ShortCodeGenerator.generate();
        }

        UrlMapping urlMapping = new UrlMapping();
        urlMapping.setLongUrl(longUrl);
        urlMapping.setShortCode(shortCode);
        urlMapping.setCreatedAt(LocalDateTime.now());

        urlRepository.save(urlMapping);
        return UrlMapper.toDto(urlMapping);
    }
    @Cacheable(value = "shortUrls", key = "#shortCode")
    public Optional<String> getLongUrl(String shortCode) {
        return urlRepository.findByShortCode(shortCode).map(UrlMapping::getLongUrl);
    }

}
