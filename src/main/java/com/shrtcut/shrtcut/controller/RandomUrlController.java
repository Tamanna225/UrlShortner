package com.shrtcut.shrtcut.controller;

import com.shrtcut.shrtcut.dto.UrlRequestDto;
import com.shrtcut.shrtcut.dto.UrlResponseDto;
import com.shrtcut.shrtcut.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/random")
//@RequiredArgsConstructor
public class RandomUrlController {
    private final UrlService urlService;
    public RandomUrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("/shorten")
    public ResponseEntity<UrlResponseDto> shortenUrl(@RequestBody UrlRequestDto urlRequestDto) {
        UrlResponseDto response = urlService.shortenUrlWithRandomCode(urlRequestDto.getLongUrl());
        return ResponseEntity.ok(response);
    }
}
