package com.example.whispy.domain.domain.repository;

import com.example.whispy.domain.domain.SoundSource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoundSourceRepository extends CrudRepository<SoundSource, Long> , SoundSourceRepositoryCustom {
}
