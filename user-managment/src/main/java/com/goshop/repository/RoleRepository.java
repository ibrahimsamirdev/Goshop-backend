package com.goshop.repository;

import com.goshop.model.Role;
import com.goshop.model.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRole(RoleType roleType);

    List<Role> findByRoleNotIn(List<RoleType> roles);

}
