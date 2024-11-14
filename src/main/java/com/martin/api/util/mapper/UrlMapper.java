package com.martin.api.util.mapper;

import com.martin.api.persistence.model.Url;
import com.martin.api.util.dto.UrlResponse;
import com.martin.api.util.dto.UrlStatsResponse;

public class UrlMapper {

  public static UrlResponse toUrlResponse(Url url) {
    if (url == null) {
      return null;
    }

    return new UrlResponse(
        url.getId(),
        url.getUrl(),
        url.getShortCode(),
        url.getCreatedAt(),
        url.getUpdatedAt()
    );
  }

  public static UrlStatsResponse toUrlStatsResponse(Url url) {
    if (url == null) {
      return null;
    }

    return new UrlStatsResponse(
        url.getId(),
        url.getUrl(),
        url.getShortCode(),
        url.getCount(),
        url.getCreatedAt(),
        url.getUpdatedAt()
    );
  }
}
