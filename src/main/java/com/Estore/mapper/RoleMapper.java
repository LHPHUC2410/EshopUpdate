package com.Estore.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.Estore.dto.reponse.RoleResponse;
import com.Estore.dto.request.RoleRequest;
import com.Estore.entity.Role;

@Mapper(componentModel = "Spring")
public interface RoleMapper {
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);

    Role updatRole(@MappingTarget Role role, RoleRequest request);

}
