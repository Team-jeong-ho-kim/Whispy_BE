package com.example.whispy.domain.service;

import com.example.whispy.global.error.ErrorCode;
import com.example.whispy.global.error.S3AudioException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class S3Service {
    private final Set<String> AUDIO_EXTENSIONS = Set.of("mp3", "wav", "ogg");

    private final S3Client s3Client;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    @Value("${cloud.aws.s3.url-prefix}")
    private String urlPrefix;

    public String upload(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        validate(fileName);

        String key = UUID.randomUUID() + "." + getExtension(fileName);

        try {
            PutObjectRequest object = PutObjectRequest.builder()
                    .bucket(bucket)
                    .key(key)
                    .contentType(file.getContentType())
                    .contentLength(file.getSize())
                    .build();

            s3Client.putObject(object, RequestBody.fromInputStream(file.getInputStream(), file.getSize()));
            return urlPrefix + key;
        } catch (Exception e) {
            throw new S3AudioException(ErrorCode.UPLOAD_AUDIO_FAILED);
        }
    }

    public void delete(String s3Url) {
        try {
            URL url = new URI(s3Url).toURL();
            String decodedKey = URLDecoder.decode(url.getPath(), StandardCharsets.UTF_8);
            String key = decodedKey.startsWith("/") ? decodedKey.substring(1) : decodedKey;

            DeleteObjectRequest object = DeleteObjectRequest.builder()
                    .bucket(bucket)
                    .key(key)
                    .build();

            s3Client.deleteObject(object);
        } catch (Exception e) {
            throw new S3AudioException(ErrorCode.DELETE_AUDIO_FAILED);
        }
    }

    private void validate(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            throw new S3AudioException(ErrorCode.AUDIO_NOT_FOUND);
        }

        String extension = getExtension(fileName);
        if (!AUDIO_EXTENSIONS.contains(extension)) {
            throw new S3AudioException(ErrorCode.INVALID_AUDIO);
        }
    }

    private String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
    }
}
