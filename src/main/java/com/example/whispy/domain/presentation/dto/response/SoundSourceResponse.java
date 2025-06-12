package com.example.whispy.domain.presentation.dto.response;

import com.example.whispy.domain.domain.enums.Theme;

import java.time.LocalDateTime;

public record SoundSourceResponse(Long id, String name, Theme theme, String s3Url, LocalDateTime createdAt) {
}
