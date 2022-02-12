package com.salat23.spring.security.waffles.models.series;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "age_restrictions")
@Entity
public class SeriesAgeRestriction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "min_age")
    private Long minAge;

}
