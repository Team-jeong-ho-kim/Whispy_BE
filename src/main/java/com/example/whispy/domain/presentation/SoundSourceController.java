package com.example.whispy.domain.presentation;

import com.example.whispy.domain.domain.enums.Theme;
import com.example.whispy.domain.presentation.dto.request.UploadRequest;
import com.example.whispy.domain.presentation.dto.response.SoundSourceResponse;
import com.example.whispy.domain.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/sound")
@RequiredArgsConstructor
public class SoundSourceController {
    private final S3Service s3Service;
    private final CreateAudioService createAudioService;
    private final DeleteAudioService deleteAudioService;
    private final QueryAllAudioService queryAllAudioService;
    private final QueryAudioByThemeService queryAudioByThemeService;

    @PostMapping("/upload")
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestPart(value = "audio") MultipartFile file) {
        s3Service.upload(file);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createSoundSource(@RequestPart(name = "request") @Valid UploadRequest request,
                                  @RequestPart(name = "audio") MultipartFile audio) {
        createAudioService.execute(request, audio);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        deleteAudioService.execute(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SoundSourceResponse> queryAll() {
        return queryAllAudioService.execute();
    }

    @GetMapping("/{theme}")
    @ResponseStatus(HttpStatus.OK)
    public List<SoundSourceResponse> queryAudioByTheme(@PathVariable Theme theme) {
        return queryAudioByThemeService.execute(theme);
    }
}
