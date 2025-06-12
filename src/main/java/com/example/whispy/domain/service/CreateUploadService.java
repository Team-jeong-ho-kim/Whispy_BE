package com.example.whispy.domain.service;

import com.example.whispy.domain.domain.SoundSource;
import com.example.whispy.domain.domain.repository.SoundSourceRepository;
import com.example.whispy.domain.presentation.dto.request.UploadRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class CreateUploadService {
    private final S3Service s3Service;
    private final SoundSourceRepository soundSourceRepository;

    @Transactional
    public void execute(UploadRequest request, MultipartFile audio) {

        String s3Url = s3Service.upload(audio);

        soundSourceRepository.save(SoundSource.builder()
                        .s3Url(s3Url)
                        .name(request.getName())
                        .theme(request.getTheme())
                .build());
    }
}
