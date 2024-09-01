package com.Estore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Estore.dto.reponse.UserRoleResponse;
import com.Estore.dto.request.UserRoleRequest;
import com.Estore.service.UserRoleService;

@RestController
@RequestMapping("/userrole")
public class UserRoleController {
    @Autowired
    private UserRoleService userRoleService;

    @PostMapping()
    public UserRoleResponse create(@RequestBody UserRoleRequest request)
    {
        return userRoleService.create(request);
    }

    // @DeleteMapping("/{id}")
    // public ApiResponse<Void> delete(@PathVariable String id)
    // {
    //     long i = Long.parseLong(id);
    //     userRoleService.delete(i);
    //     return ApiResponse.<Void>builder().build();
    // }
}
