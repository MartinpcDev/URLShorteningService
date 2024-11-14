package com.martin.api.controller;

import com.martin.api.service.IUrlService;
import com.martin.api.util.dto.UrlRequest;
import com.martin.api.util.dto.UrlResponse;
import com.martin.api.util.dto.UrlStatsResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shorten")
@RequiredArgsConstructor
public class UrlShorteningController {

  private final IUrlService urlService;

  @GetMapping("/{shortUrl}")
  public ResponseEntity<UrlResponse> getOriginalUrl(@PathVariable String shortUrl) {
    return ResponseEntity.ok(urlService.getByShorUrl(shortUrl));
  }

  @GetMapping("/{shortUrl}/stats")
  public ResponseEntity<UrlStatsResponse> getStatsUrl(@PathVariable String shortUrl) {
    return ResponseEntity.ok(urlService.getStatsByShortUrl(shortUrl));
  }

  @PostMapping
  public ResponseEntity<UrlResponse> createShortenUrl(@RequestBody @Valid UrlRequest request) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(urlService.createUrl(request));
  }

  @PutMapping("/{shortUrl}")
  public ResponseEntity<UrlResponse> updateShortenUrl(@PathVariable String shortUrl,
      @RequestBody @Valid UrlRequest request) {
    return ResponseEntity.ok(urlService.updateUrl(shortUrl, request));
  }

  @DeleteMapping("/{shortUrl}")
  public ResponseEntity<?> deleteShortenUrl(@PathVariable String shortUrl) {
    urlService.deleteUrl(shortUrl);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
