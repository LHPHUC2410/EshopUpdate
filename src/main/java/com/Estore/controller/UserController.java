package com.Estore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Estore.dto.reponse.ApiResponse;
import com.Estore.dto.reponse.UserResponse;
import com.Estore.dto.request.UserRequest;
import com.Estore.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired 
    private UserService userService;

    @PostMapping()
    public ApiResponse<UserResponse> create(@RequestBody UserRequest request)
    {
        return ApiResponse.<UserResponse>builder()
        .result(userService.create(request))
        .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<UserResponse> getUserbyId(@PathVariable String id) {
        return ApiResponse.<UserResponse>builder()
        .result(userService.getUserbyId(id))
        .build();
    }
    @GetMapping()
    public ApiResponse<List<UserResponse>> getAllUser()
    {
        return ApiResponse.<List<UserResponse>>builder()
        .result(userService.getAllUser())
        .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable String id) 
    {
        userService.delete(id);
        return ApiResponse.<Void>builder().build();
    }

    @PutMapping("/{id}")
    public ApiResponse<UserResponse> update(@PathVariable String id, @RequestBody UserRequest request)
    {
        return ApiResponse.<UserResponse>builder()
        .result(userService.update(id, request))
        .build();
    }
}
