package com.goshop.service;

import com.goshop.model.Role;
import com.goshop.model.RoleType;

public interface RoleService {

    Role getRoleByType(RoleType type);
}
