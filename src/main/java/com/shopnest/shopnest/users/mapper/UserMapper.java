package com.shopnest.shopnest.users.mapper;

import com.shopnest.shopnest.users.dto.requests.CreateUserDto;
import com.shopnest.shopnest.users.dto.responses.UserDto;
import com.shopnest.shopnest.users.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(UserEntity user);
    UserEntity fromUserDto(UserDto userDto);
    CreateUserDto toCreateUserDto(UserEntity userEntity);
    UserEntity fromCreateUserDto(CreateUserDto createUserDto);
}