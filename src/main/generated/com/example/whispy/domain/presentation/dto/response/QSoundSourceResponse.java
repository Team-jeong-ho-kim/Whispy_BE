package com.example.whispy.domain.presentation.dto.response;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.whispy.domain.presentation.dto.response.QSoundSourceResponse is a Querydsl Projection type for SoundSourceResponse
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QSoundSourceResponse extends ConstructorExpression<SoundSourceResponse> {

    private static final long serialVersionUID = 1934257584L;

    public QSoundSourceResponse(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> name, com.querydsl.core.types.Expression<com.example.whispy.domain.domain.enums.Theme> theme, com.querydsl.core.types.Expression<String> s3Url, com.querydsl.core.types.Expression<java.time.LocalDateTime> createdAt) {
        super(SoundSourceResponse.class, new Class<?>[]{long.class, String.class, com.example.whispy.domain.domain.enums.Theme.class, String.class, java.time.LocalDateTime.class}, id, name, theme, s3Url, createdAt);
    }

}

