package com.goshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goshop.model.RoleType;
import com.goshop.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByRole(RoleType role);

	List<User> findByVendor_Id(long id);

	List<User> findByRole_Role(RoleType roleType);

}
