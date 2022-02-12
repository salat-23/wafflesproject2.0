package com.salat23.spring.security.waffles.repository;

import com.salat23.spring.security.waffles.models.series.Series;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeriesRepository extends JpaRepository<Series, Long> {

    Optional<Series> findSeriesByTitle(String title);

}
