package com.shrtcut.shrtcut.controller;

import com.shrtcut.shrtcut.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/r")
//@RequiredArgsConstructor
public class RedirectController {
    private final UrlService urlService;
    public RedirectController(UrlService urlService) {
        this.urlService = urlService;
    }
    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirectToLongUrl(@PathVariable String shortCode) {
        if (shortCode == null || shortCode.isBlank()) {
            return ResponseEntity.badRequest().build(); // Handle empty shortCode
        }

        Optional<String> longUrlOpt = urlService.getLongUrl(shortCode);

        if (longUrlOpt.isPresent()) {
            try {
                URI redirectUri = URI.create(longUrlOpt.get());
                return ResponseEntity.status(302).location(redirectUri).build();
            } catch (IllegalArgumentException e) {
                return ResponseEntity.badRequest().body(null); // Handle invalid URLs
            }
        }

        return ResponseEntity.notFound().build();
    }
}
