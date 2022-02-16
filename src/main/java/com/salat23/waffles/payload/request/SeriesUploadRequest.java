package com.salat23.waffles.payload.request;

import lombok.Data;

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
