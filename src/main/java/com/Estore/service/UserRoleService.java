package com.Estore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Estore.dto.reponse.UserRoleResponse;
import com.Estore.dto.request.UserRoleRequest;
import com.Estore.entity.Role;
import com.Estore.entity.User;
import com.Estore.entity.UserRole;
import com.Estore.repository.RoleRepository;
import com.Estore.repository.UserRepository;
import com.Estore.repository.UserRoleRepository;

@Service
public class UserRoleService {
    @Autowired
    private UserRoleRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public UserRoleResponse create(UserRoleRequest request)
    {
        UserRole userRole = new UserRole();
        User user = userRepository.findById(request.getUser_id()).orElse(null);
        Role role = roleRepository.findById(request.getRole_name()).orElse(null);

        userRole.setUser(user);
        userRole.setRole(role);
        repository.save(userRole);

        UserRoleResponse result = new UserRoleResponse();
        result.setId(userRole.getId());
        result.setUsername(user.getUsername());
        result.setRolename(role.getName());
        return result;
    }

    public void delete(long id)
    {
        repository.deleteById(id);
    }
}
