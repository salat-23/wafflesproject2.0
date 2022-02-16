package com.salat23.waffles.payload.request;

import lombok.Data;

import java.util.Set;

@Data
public class AddTagsToSeriesRequest {

    private Set<Long> tagIds;

}
