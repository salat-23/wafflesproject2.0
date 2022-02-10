package com.salat23.wafflesfullstack.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity(name = "animes")
@EqualsAndHashCode(callSuper = false)
public class Anime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String studio;
    private String director;

    @OneToOne
    private CloudImage cover;

}
