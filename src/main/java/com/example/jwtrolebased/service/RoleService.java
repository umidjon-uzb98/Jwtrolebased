package com.example.jwtrolebased.service;

import com.example.jwtrolebased.domain.Role;
import com.example.jwtrolebased.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepo roleRepo;

    public Role getByName(String name){
        return roleRepo.findByName(name);
    }

    public Role save(Role role){
        return roleRepo.save(role);
    }

}
