package com.Estore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Estore.dto.reponse.UserResponse;
import com.Estore.dto.request.UserRequest;
import com.Estore.entity.User;
import com.Estore.exception.AppException;
import com.Estore.exception.ErrorCode;
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
        if(userRepository.existsByUsername(request.getUsername()))
        {
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        User user = userMapper.toUser(request);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
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
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);

        return userMapper.toUserResponse(user);
    }
}
