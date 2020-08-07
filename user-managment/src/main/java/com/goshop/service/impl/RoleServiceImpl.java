package com.goshop.service.impl;

import com.goshop.model.Role;
import com.goshop.model.RoleType;
import com.goshop.repository.RoleRepository;
import com.goshop.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role getRoleByType(RoleType type) {
        Role role = roleRepository.findByRole(type);
        if(role == null){
            role = new Role();
            role.setRole(type);
            role = roleRepository.save(role);
        }
        return role;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
