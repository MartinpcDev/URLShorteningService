package com.martin.api.util.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;

public record UrlResponse(
    Long id,
    String url,
    @JsonProperty("shortCode")
    String shortCode,
    @JsonProperty("createdAt")
    LocalDateTime createdAt,
    @JsonProperty("updatedAt")
    LocalDateTime updatedAt
) {

}
