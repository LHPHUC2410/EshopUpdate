package com.Estore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Estore.dto.reponse.RoleResponse;
import com.Estore.dto.request.RoleRequest;
import com.Estore.entity.Role;
import com.Estore.mapper.RoleMapper;
import com.Estore.repository.RoleRepository;

@Service
public class RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleRepository roleRepository;

    public RoleResponse create(RoleRequest request) 
    {
        Role role  = roleMapper.toRole(request);
        roleRepository.save(role);
        return roleMapper.toRoleResponse(role);
    }

    public void delete(String id) 
    {
        roleRepository.deleteById(id);
    }

    public List<RoleResponse> getAll() 
    {
        return roleRepository.findAll().stream()
        .map(roleMapper::toRoleResponse).toList();
    }

    public RoleResponse update(String id,RoleRequest request)
    {
        Role role = roleRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Role not found"));
        roleMapper.updatRole(role, request);
        roleRepository.save(role);
        return roleMapper.toRoleResponse(role);
        
    }
}
