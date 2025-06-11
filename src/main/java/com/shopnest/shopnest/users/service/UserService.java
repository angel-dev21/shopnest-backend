package com.shopnest.shopnest.users.service;

import com.shopnest.shopnest.users.dto.CreateUserDto;
import com.shopnest.shopnest.users.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(CreateUserDto createUserDto);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUsers();

    UserDto updateUser(Long userId, UserDto updatedUser);

    void deleteUser(Long userId);
}
