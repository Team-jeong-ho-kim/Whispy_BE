package com.example.whispy.domain.service;

import com.example.whispy.domain.domain.SoundSource;
import com.example.whispy.domain.domain.repository.SoundSourceRepository;
import com.example.whispy.domain.presentation.dto.request.DeleteRequest;
import com.example.whispy.global.error.ErrorCode;
import com.example.whispy.global.error.S3AudioException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteAudioService {
    private final SoundSourceRepository soundSourceRepository;

    @Transactional
    public void execute(Long id, DeleteRequest request) {
        SoundSource soundSource = soundSourceRepository.findById(id)
                .orElseThrow(() -> new S3AudioException(ErrorCode.AUDIO_NOT_FOUND));

        soundSourceRepository.delete(soundSource);
    }
}
