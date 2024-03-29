package com.salat23.waffles.repository;

import java.util.Optional;

import com.salat23.waffles.models.ERole;
import com.salat23.waffles.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
