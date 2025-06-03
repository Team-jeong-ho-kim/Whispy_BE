package com.example.whispy.domain.presentation;

import com.example.whispy.domain.presentation.dto.request.DeleteRequest;
import com.example.whispy.domain.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/sound")
@RequiredArgsConstructor
public class SoundSourceController {
    private final S3Service s3Service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestPart(value = "audio") MultipartFile file) throws IOException {
        s3Service.upload(file);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestBody @Valid DeleteRequest request) {
        s3Service.delete(request.getS3Url());
    }

}
