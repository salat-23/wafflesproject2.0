package com.salat23.wafflesfullstack.repository;

import com.salat23.wafflesfullstack.entity.Role;
import com.salat23.wafflesfullstack.entity.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleEnum name);
}
