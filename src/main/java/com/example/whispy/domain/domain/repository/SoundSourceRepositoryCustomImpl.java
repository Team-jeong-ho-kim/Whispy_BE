package com.example.whispy.domain.domain.repository;

import com.example.whispy.domain.domain.QSoundSource;
import com.example.whispy.domain.domain.enums.Theme;
import com.example.whispy.domain.presentation.dto.response.QSoundSourceResponse;
import com.example.whispy.domain.presentation.dto.response.SoundSourceResponse;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SoundSourceRepositoryCustomImpl implements SoundSourceRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QSoundSource qSoundSource = QSoundSource.soundSource;

    @Override
    public List<SoundSourceResponse> queryAllAudio() {
        return jpaQueryFactory
                .select(new QSoundSourceResponse(
                        qSoundSource.id,
                        qSoundSource.name,
                        qSoundSource.theme,
                        qSoundSource.s3Url,
                        qSoundSource.createdAt
                ))
                .from(qSoundSource)
                .orderBy(qSoundSource.createdAt.desc())
                .fetch();
    }

    @Override
    public List<SoundSourceResponse> queryAudioByTheme(Theme theme) {
        return jpaQueryFactory
                .select(new QSoundSourceResponse(
                        qSoundSource.id,
                        qSoundSource.name,
                        qSoundSource.theme,
                        qSoundSource.s3Url,
                        qSoundSource.createdAt
                ))
                .from(qSoundSource)
                .where(qSoundSource.theme.eq(theme))
                .orderBy(qSoundSource.createdAt.desc())
                .fetch();
    }


}
