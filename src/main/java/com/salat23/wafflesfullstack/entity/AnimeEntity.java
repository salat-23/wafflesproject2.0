package com.salat23.wafflesfullstack.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Data
@Entity(name = "Anime")
@EqualsAndHashCode(callSuper = false)
public class AnimeEntity extends BaseEntity {

    private String title;
    private String description;
    private String studio;
    private String director;

    @OneToOne
    private CloudImageEntity cover;

}
