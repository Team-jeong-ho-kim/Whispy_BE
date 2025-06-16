package com.example.whispy.domain.presentation.dto.response;

import com.example.whispy.domain.domain.enums.Theme;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SoundSourceResponse {

    private Long id;

    private String name;

    private Theme theme;

    private String s3Url;

    private LocalDateTime createdAt;

    @QueryProjection
    public SoundSourceResponse(Long id, String name, Theme theme, String s3Url, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.theme = theme;
        this.s3Url = s3Url;
        this.createdAt = createdAt;
    }
}
