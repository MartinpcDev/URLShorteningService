package com.martin.api.service;

import com.martin.api.util.dto.UrlRequest;
import com.martin.api.util.dto.UrlResponse;
import com.martin.api.util.dto.UrlStatsResponse;

public interface IUrlService {

  UrlResponse getByShorUrl(String shortUrl);

  UrlStatsResponse getStatsByShortUrl(String shortUrl);

  UrlResponse createUrl(UrlRequest request);

  UrlResponse updateUrl(String shortCode, UrlRequest request);

  void deleteUrl(String shortUrl);
}
