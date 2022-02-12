package com.salat23.spring.security.waffles.models;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@Table(	name = "expanded_users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "user_id")
        })
public class ExpandedUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    private ImageResource avatar;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ExpandedUser that = (ExpandedUser) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
