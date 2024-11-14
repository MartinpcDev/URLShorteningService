package com.martin.api.util.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonInclude(Include.NON_NULL)
public record ExceptionResponse(
    String message,
    @JsonProperty("server_message")
    String exceptionMessage,
    List<String> details
) {

}
