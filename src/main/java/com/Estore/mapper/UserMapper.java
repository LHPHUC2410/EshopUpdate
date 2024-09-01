package com.Estore.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.Estore.dto.reponse.UserResponse;
import com.Estore.dto.request.UserRequest;
import com.Estore.entity.User;

@Mapper(componentModel = "Spring")
public interface UserMapper {
    User toUser(UserRequest request);

    UserResponse toUserResponse(User user);

    User updateUser(@MappingTarget User user, UserRequest request);
}
