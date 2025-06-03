package com.example.whispy.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error"),
    UPLOAD_AUDIO_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "Audio Upload Failed"),
    DELETE_AUDIO_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "Audio Delete Failed"),
    AUDIO_NOT_FOUND(HttpStatus.NOT_FOUND, "Audio Not Found"),
    INVALID_AUDIO(HttpStatus.BAD_REQUEST, "Invalid Audio");

    private final HttpStatus status;
    private final String message;

}
