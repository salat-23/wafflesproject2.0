package com.salat23.waffles.repository;

import com.salat23.waffles.models.series.Series;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeriesRepository extends JpaRepository<Series, Long> {

    Optional<Series> findSeriesByTitle(String title);

}
