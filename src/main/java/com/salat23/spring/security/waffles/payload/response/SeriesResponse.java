package com.salat23.spring.security.waffles.payload.response;

import lombok.Data;

import java.util.Set;

@Data
public class SeriesResponse {

    private String title;

    private String description;

    private String cover;

    private Set<String> tags;

    private String director;

    private String type;

    private String status;

    private String source;

    private String studio;

    private Long ageRestriction;

    private Set<EpisodeSetResponse> episodeVariants;

}
