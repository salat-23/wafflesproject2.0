package com.salat23.spring.security.waffles.payload.request;

import lombok.Data;

import java.util.Set;

@Data
public class AddTagsToSeriesRequest {

    private Set<Long> tagIds;

}
