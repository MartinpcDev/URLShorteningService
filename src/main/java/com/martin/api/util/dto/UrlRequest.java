package com.martin.api.util.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

public record UrlRequest(
    @NotBlank(message = "El url no puede ir vacio")
    @URL(message = "El url debe tener un formato valido")
    String url
) {

}
