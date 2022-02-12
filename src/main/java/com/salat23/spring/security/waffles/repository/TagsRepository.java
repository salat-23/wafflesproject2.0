package com.salat23.spring.security.waffles.repository;

import com.salat23.spring.security.waffles.models.series.SeriesTag;
import com.salat23.spring.security.waffles.models.series.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TagsRepository extends JpaRepository<Tag, Long> {

    Optional<Tag> findByName(String name);

}
