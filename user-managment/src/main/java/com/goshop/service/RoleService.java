package com.goshop.service;

import com.goshop.model.Role;
import com.goshop.model.RoleType;
import com.goshop.model.User;

import java.util.List;

public interface RoleService {

    Role getRoleByType(RoleType type);
    List<Role> getAllRoles();
    List<Role> getVendorsEmployeesRoles();

}
