package com.salat23.waffles.repository;

import com.salat23.waffles.models.series.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TagsRepository extends JpaRepository<Tag, Long> {

    Optional<Tag> findByName(String name);

}
