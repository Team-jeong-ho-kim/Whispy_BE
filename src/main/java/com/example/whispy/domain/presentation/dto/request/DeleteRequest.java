package com.example.whispy.domain.presentation.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeleteRequest {

    @NotNull(message = "null일 수 없습니다")
    private String audioUrl;
}
