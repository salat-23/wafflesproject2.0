package com.salat23.spring.security.waffles.repository;

import com.salat23.spring.security.waffles.models.ImageResource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageResourceRepository extends JpaRepository<ImageResource, Long> {

    ImageResource findImageResourceById(Long id);

}
