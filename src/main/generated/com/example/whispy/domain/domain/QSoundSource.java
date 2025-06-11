package com.example.whispy.domain.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSoundSource is a Querydsl query type for SoundSource
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSoundSource extends EntityPathBase<SoundSource> {

    private static final long serialVersionUID = -1110199151L;

    public static final QSoundSource soundSource = new QSoundSource("soundSource");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final StringPath s3Url = createString("s3Url");

    public final EnumPath<com.example.whispy.domain.domain.enums.Theme> theme = createEnum("theme", com.example.whispy.domain.domain.enums.Theme.class);

    public QSoundSource(String variable) {
        super(SoundSource.class, forVariable(variable));
    }

    public QSoundSource(Path<? extends SoundSource> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSoundSource(PathMetadata metadata) {
        super(SoundSource.class, metadata);
    }

}

