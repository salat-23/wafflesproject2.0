package com.salat23.spring.security.waffles.payload.response;

import com.salat23.spring.security.waffles.models.Episode;
import lombok.Data;

import javax.persistence.OneToMany;
import java.util.Set;

@Data
public class EpisodeSetResponse {


    private String name;

    private Set<Episode> episodes;

}
