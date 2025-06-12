package com.example.whispy.domain.presentation.dto.request;

import com.example.whispy.domain.domain.enums.Theme;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class UploadRequest {

    @NotNull
    private String name;

    @NotNull
    private Theme theme;
}
