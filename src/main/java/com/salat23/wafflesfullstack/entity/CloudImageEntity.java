package com.salat23.wafflesfullstack.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;


@Data
@Entity(name = "CloudImage")
@EqualsAndHashCode(callSuper = false)
public class CloudImageEntity extends BaseEntity {

    private String publicId;
    private String url;
    private String secureUrl;

    public void setData(String publicId, String url, String secureUrl) {
        this.publicId = publicId;
        this.secureUrl = secureUrl;
        this.url = url;
    }

}
