package com.shrtcut.shrtcut.controller;

import com.shrtcut.shrtcut.dto.UrlRequestDto;
import com.shrtcut.shrtcut.dto.UrlResponseDto;
import com.shrtcut.shrtcut.service.UrlService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@RestController //this extends controller. This is a type of controller
//@RequestMapping("/api/custom")  //specifies the base url
//@RequiredArgsConstructor    //generates constructor for finsl or nonnull fields
//public class CustomUrlController {
//    private final UrlService urlService;
//    @PostMapping("/shorten")
//    public ResponseEntity<UrlResponseDto> shortenUrl(@Valid @RequestBody UrlRequestDto urlRequestDto) {
//        return ResponseEntity.ok(urlService.shortenUrlWithCustomCode(urlRequestDto));
//    }
//}

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/custom")
public class CustomUrlController {

    private final UrlService urlService;

    @Autowired
    public CustomUrlController(UrlService urlService) {
        this.urlService = urlService; // Now it is initialized properly
    }

    @PostMapping("/shorten")
    public ResponseEntity<UrlResponseDto> shortenUrl(@Valid @RequestBody UrlRequestDto urlRequestDto) {
        return ResponseEntity.ok(urlService.shortenUrlWithCustomCode(urlRequestDto));
    }
}

