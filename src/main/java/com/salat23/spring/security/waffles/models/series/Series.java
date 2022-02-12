package com.salat23.spring.security.waffles.models.series;

import com.salat23.spring.security.waffles.models.EpisodesSet;
import com.salat23.spring.security.waffles.models.ImageResource;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "series")
public class Series {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @OneToMany(mappedBy = "series")
    private Set<SeriesTag> tags;

    @OneToOne
    private ImageResource cover;

    @ManyToOne
    private Director director;

    @ManyToOne
    private SeriesType type;

    @ManyToOne
    private SeriesStatus status;

    @ManyToOne
    private SeriesSource source;

    @ManyToOne
    private Studio studio;

    @ManyToOne
    private SeriesAgeRestriction ageRestriction;

    @OneToMany
    private Set<EpisodesSet> episodeVariants;

}
