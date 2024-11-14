package com.martin.api.service.impl;

import com.martin.api.exception.UrlNotFoundException;
import com.martin.api.persistence.model.Url;
import com.martin.api.persistence.repository.UrlRepository;
import com.martin.api.service.IUrlService;
import com.martin.api.util.dto.UrlRequest;
import com.martin.api.util.dto.UrlResponse;
import com.martin.api.util.dto.UrlStatsResponse;
import com.martin.api.util.mapper.UrlMapper;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UrlService implements IUrlService {

  private final UrlRepository urlRepository;

  @Override
  public UrlResponse getByShorUrl(String shortUrl) {
    Url urlExists = urlRepository.findByShortCode(shortUrl)
        .orElseThrow(() -> new UrlNotFoundException("url con " + shortUrl + " no existe."));
    urlExists.setCount(urlExists.getCount() + 1);
    Url savedUrl = urlRepository.save(urlExists);
    return UrlMapper.toUrlResponse(savedUrl);
  }

  @Override
  public UrlStatsResponse getStatsByShortUrl(String shortUrl) {
    Url urlExists = urlRepository.findByShortCode(shortUrl)
        .orElseThrow(() -> new UrlNotFoundException("url con " + shortUrl + " no existe."));
    return UrlMapper.toUrlStatsResponse(urlExists);
  }

  @Override
  public UrlResponse createUrl(UrlRequest request) {
    Url url = new Url();
    url.setUrl(request.url());
    url.setShortCode(generateShortCode());
    url.setCount(0);
    Url createdUrl = urlRepository.save(url);
    return UrlMapper.toUrlResponse(createdUrl);
  }

  @Override
  public UrlResponse updateUrl(String shortCode, UrlRequest request) {
    Url urlExists = urlRepository.findByShortCode(shortCode)
        .orElseThrow(() -> new UrlNotFoundException("url con " + shortCode + " no existe."));
    urlExists.setUrl(request.url());
    urlExists.setShortCode(generateShortCode());
    urlExists.setCount(0);
    Url updatedUrl = urlRepository.save(urlExists);
    return UrlMapper.toUrlResponse(updatedUrl);
  }

  @Override
  public void deleteUrl(String shortUrl) {
    Url urlExists = urlRepository.findByShortCode(shortUrl)
        .orElseThrow(() -> new UrlNotFoundException("url con " + shortUrl + " no existe."));
    urlRepository.delete(urlExists);
  }

  private String generateShortCode() {
    UUID uuid = UUID.randomUUID();
    return uuid.toString().substring(0, 5);
  }
}
