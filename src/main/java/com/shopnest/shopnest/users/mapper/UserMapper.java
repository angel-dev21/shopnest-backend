package com.shopnest.shopnest.users.mapper;

import com.shopnest.shopnest.users.dto.UserDto;
import com.shopnest.shopnest.users.entity.UserEntity;

public class UserMapper {

    public static UserDto mapToCartItemDto(UserEntity user) {
        return new UserDto(
                user.getUserId(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName()
        );
    }

    public static UserEntity mapToCartItem(UserDto userDto) {
        return new UserEntity(
                userDto.getUserId(),
                userDto.getUsername(),
                userDto.getPassword(),
                userDto.getEmail(),
                userDto.getFirstName(),
                userDto.getLastName()
        );
    }
}
