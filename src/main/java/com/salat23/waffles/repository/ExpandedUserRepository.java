package com.salat23.waffles.repository;

import com.salat23.waffles.models.ExpandedUser;
import com.salat23.waffles.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpandedUserRepository extends JpaRepository<ExpandedUser, Long> {

    ExpandedUser findExpandedUserByUser(User user);

}
