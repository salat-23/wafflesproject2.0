package com.salat23.waffles.repository;

import com.salat23.waffles.models.ImageResource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageResourceRepository extends JpaRepository<ImageResource, Long> {

    ImageResource findImageResourceById(Long id);

}
