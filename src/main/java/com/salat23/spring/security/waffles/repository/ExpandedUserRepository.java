package com.salat23.spring.security.waffles.repository;

import com.salat23.spring.security.waffles.models.ExpandedUser;
import com.salat23.spring.security.waffles.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpandedUserRepository extends JpaRepository<ExpandedUser, Long> {

    ExpandedUser findExpandedUserByUser(User user);

}
