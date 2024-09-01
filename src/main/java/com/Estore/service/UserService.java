package com.Estore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Estore.dto.reponse.UserResponse;
import com.Estore.dto.request.UserRequest;
import com.Estore.entity.User;
import com.Estore.mapper.UserMapper;
import com.Estore.repository.UserRepository;

@Service
public class UserService {

    @Autowired 
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public UserResponse create(UserRequest request)
    {
        User user = userMapper.toUser(request);
        userRepository.save(user);
        return userMapper.toUserResponse(user);
    }

    public UserResponse getUserbyId(String id) {
        return userMapper.toUserResponse(userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("User not found")));
    }

    public List<UserResponse> getAllUser() {
        return userRepository.findAll().stream().map(userMapper::toUserResponse).toList();
    }

    public void delete(String id) {
        userRepository.deleteById(id);
    }

    public UserResponse update(String id, UserRequest request)
    {
        User user = userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("User not found"));

        userMapper.updateUser(user, request);
        userRepository.save(user);

        return userMapper.toUserResponse(user);
    }
}
