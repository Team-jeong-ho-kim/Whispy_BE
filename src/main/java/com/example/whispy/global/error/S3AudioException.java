package com.example.whispy.global.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class S3AudioException extends RuntimeException {
    private final ErrorCode errorCode;
}

