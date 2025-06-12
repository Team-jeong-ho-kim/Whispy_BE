package com.example.whispy.domain.domain;

import com.example.whispy.domain.domain.enums.Theme;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SoundSource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 10, nullable = false)
    private String name;

    @Column(nullable = false)
    private String s3Url;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Theme theme;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

}
