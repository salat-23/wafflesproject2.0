package com.salat23.spring.security.waffles.repository;

import com.salat23.spring.security.waffles.models.series.SeriesTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface SeriesTagRepository extends JpaRepository<SeriesTag, Long> {

    Set<SeriesTag> findSeriesTagsBySeries_Title(String title);

    boolean existsBySeries_TitleAndTag_Id(String series_title, Long tag_id);

}
