package org.example.evangelhistory.repositories;

import org.example.evangelhistory.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
