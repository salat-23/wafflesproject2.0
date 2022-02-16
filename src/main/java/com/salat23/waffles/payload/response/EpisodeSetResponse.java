package com.salat23.waffles.payload.response;

import com.salat23.waffles.models.Episode;
import lombok.Data;

import java.util.Set;

@Data
public class EpisodeSetResponse {


    private String name;

    private Set<Episode> episodes;

}
