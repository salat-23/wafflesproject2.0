package com.salat23.wafflesfullstack.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Data
@Entity(name = "Episode")
@EqualsAndHashCode(callSuper = false)
public class EpisodeEntity extends BaseEntity {
    private String title;
}
