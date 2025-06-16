package com.shopnest.shopnest.users.service;
import com.shopnest.shopnest.exceptions.ResourceNotFoundException;
import com.shopnest.shopnest.users.dto.UserDto;
import com.shopnest.shopnest.users.entity.UserEntity;
import com.shopnest.shopnest.users.mapper.UserMapper;
import com.shopnest.shopnest.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.shopnest.shopnest.users.dto.CreateUserDto;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserDto createUser(CreateUserDto createUserDto) {
        UserEntity user = userMapper.fromCreateUserDto(createUserDto);
        UserEntity savedUser = userRepository.save(user);
        return userMapper.toUserDto(savedUser);
    }

    public UserDto getUserById(Long userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with the id " + userId + " doesn't exist"));
        return userMapper.toUserDto(user);
    }

    public List<UserDto> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream().map(userMapper::toUserDto).collect(Collectors.toList());
    }

    public UserDto updateUser(Long userId, UserDto updatedUser) {
        UserEntity user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User with the id " + userId + " doesn't exist")
        );
        user.setUsername(updatedUser.getUsername());
        user.setPassword(updatedUser.getPassword());
        user.setEmail(updatedUser.getEmail());
        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        UserEntity savedUser = userRepository.save(user);
        return userMapper.toUserDto(savedUser);
    }

    public void deleteUser(Long userId) {
        UserEntity user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User with the id " + userId + "dont exist" )
        );
        userRepository.delete(user);
    }

}