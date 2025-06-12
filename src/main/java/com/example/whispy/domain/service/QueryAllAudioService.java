package com.example.whispy.domain.service;

import com.example.whispy.domain.domain.repository.SoundSourceRepository;
import com.example.whispy.domain.presentation.dto.response.SoundSourceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryAllAudioService {
    private final SoundSourceRepository soundSourceRepository;

    @Transactional(readOnly = true)
    public List<SoundSourceResponse> execute() {
        return soundSourceRepository.queryAllAudio();
    }
}
