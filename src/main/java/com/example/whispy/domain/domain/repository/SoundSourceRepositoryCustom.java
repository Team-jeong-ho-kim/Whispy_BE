package com.example.whispy.domain.domain.repository;

import com.example.whispy.domain.domain.enums.Theme;
import com.example.whispy.domain.presentation.dto.response.SoundSourceResponse;

import java.util.List;

public interface SoundSourceRepositoryCustom {
    List<SoundSourceResponse> queryAllAudio();
    List<SoundSourceResponse> queryAudioByTheme(Theme theme);
}
