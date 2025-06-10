package com.shopnest.shopnest.users.mapper;

import com.shopnest.shopnest.users.dto.CreateUserDto;
import com.shopnest.shopnest.users.dto.UserDto;
import com.shopnest.shopnest.users.entity.UserEntity;

public class UserMapper {
    public static UserDto mapToUserDto(UserEntity user) {
        return new UserDto(
                user.getUserId(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName()
        );
    }

    public static UserEntity mapToNewUser(CreateUserDto userDto) {
        UserEntity user = new UserEntity();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        return user;
    }
}