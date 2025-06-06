package com.shopnest.shopnest.users.service.impl;
import com.shopnest.shopnest.users.dto.UserDto;
import com.shopnest.shopnest.users.entity.UserEntity;
import com.shopnest.shopnest.users.exception.ResourceNotFoundException;
import com.shopnest.shopnest.users.mapper.UserMapper;
import com.shopnest.shopnest.users.repository.UserRepository;
import com.shopnest.shopnest.users.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        UserEntity user = UserMapper.mapToCartItem(userDto);
        UserEntity savedUser = userRepository.save(user);

        return UserMapper.mapToCartItemDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with the id " + userId + "dont exist" ));

        return UserMapper.mapToCartItemDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {

        List<UserEntity> users = userRepository.findAll();
        return users.stream().map((user) -> UserMapper.mapToCartItemDto(user))
                .collect(Collectors.toList());

    }

    @Override
    public UserDto updateUser(Long userId, UserDto updatedUser) {
        UserEntity user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User with the id " + userId + "dont exist" )
        );

        user.setUsername(updatedUser.getUsername());
        user.setPassword(updatedUser.getPassword());
        user.setEmail(updatedUser.getEmail());
        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        //user.setRole(updatedUser.getRole());

        UserEntity savedUser = userRepository.save(user);

        return UserMapper.mapToCartItemDto(savedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        UserEntity user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User with the id " + userId + "dont exist" )
        );
        userRepository.delete(user);
    }

}
