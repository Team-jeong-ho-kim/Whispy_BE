package com.example.whispy.domain.domain;

import com.example.whispy.domain.domain.enums.Theme;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SoundSource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 10, nullable = false)
    private String title;

    @Column(nullable = false)
    private String s3Url;

    @Column(nullable = false)
    private Theme theme;

}
