package com.salat23.spring.security.waffles.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.salat23.spring.security.waffles.payload.response.EpisodeSetResponse;
import lombok.Data;

import java.util.Set;

@Data
public class SeriesUploadRequest {

    private String title;

    private String description;

    //TODO: add cover upload endpoint

    private Long directorId;

    private Long typeId;

    private Long statusId;

    private Long sourceId;

    private Long studioId;

    private Long ageRestriction;

}
