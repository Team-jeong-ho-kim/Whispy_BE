package com.example.whispy.domain.domain.repository;

import com.example.whispy.domain.domain.QSoundSource;
import com.example.whispy.domain.domain.enums.Theme;
import com.example.whispy.domain.presentation.dto.response.SoundSourceResponse;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SoundSourceRepositoryCustomImpl implements SoundSourceRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QSoundSource qSoundSource = QSoundSource.soundSource;

    @Override
    public List<SoundSourceResponse> queryAllAudio() {
        return jpaQueryFactory.select(Projections.constructor(
                        SoundSourceResponse.class,
                        qSoundSource.id,
                        qSoundSource.name,
                        qSoundSource.s3Url,
                        qSoundSource.theme,
                        qSoundSource.createdAt
                ))
                .from(qSoundSource)
                .orderBy(qSoundSource.createdAt.desc())
                .fetch();
    }

    @Override
    public List<SoundSourceResponse> queryAudioByTheme(Theme theme) {
        return jpaQueryFactory.select(Projections.constructor(
                SoundSourceResponse.class,
                qSoundSource.id,
                qSoundSource.name,
                qSoundSource.s3Url,
                qSoundSource.theme,
                qSoundSource.createdAt
        ))
                .from(qSoundSource)
                .where(qSoundSource.theme.eq(theme))
                .orderBy(qSoundSource.createdAt.desc())
                .fetch();
    }

}
