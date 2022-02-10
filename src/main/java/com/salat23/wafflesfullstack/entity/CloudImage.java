package com.salat23.wafflesfullstack.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@Entity(name = "images")
@EqualsAndHashCode(callSuper = false)
public class CloudImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String publicId;
    private String url;
    private String secureUrl;

    public void setData(String publicId, String url, String secureUrl) {
        this.publicId = publicId;
        this.secureUrl = secureUrl;
        this.url = url;
    }

}
