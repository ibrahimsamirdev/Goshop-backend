package com.goshop.repository;

import com.goshop.model.Role;
import com.goshop.model.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRole(RoleType roleType);

}
