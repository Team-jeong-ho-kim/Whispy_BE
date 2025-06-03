package com.example.whispy.global.error;

import lombok.Builder;
import org.springframework.http.HttpStatus;
@Builder
public record ErrorResponse(HttpStatus status, String message) {
}
