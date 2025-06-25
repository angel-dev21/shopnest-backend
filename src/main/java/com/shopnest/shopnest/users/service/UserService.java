package com.shopnest.shopnest.users.service;
import com.shopnest.shopnest.exceptions.ResourceNotFoundException;
import com.shopnest.shopnest.users.dto.responses.UserDto;
import com.shopnest.shopnest.users.entity.UserEntity;
import com.shopnest.shopnest.users.mapper.UserMapper;
import com.shopnest.shopnest.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.shopnest.shopnest.users.dto.requests.CreateUserDto;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public UserDto createUser(CreateUserDto createUserDto) {
        if(userRepository.existsUserEntitiesByEmail(createUserDto.getEmail())) {
            throw new ResourceNotFoundException("User with email " + createUserDto.getEmail() + " already exists");
        }
        UserEntity user = userMapper.fromCreateUserDto(createUserDto);
        user.setPassword(bCryptPasswordEncoder.encode(createUserDto.getPassword()));
        UserEntity savedUser = userRepository.save(user);
        return userMapper.toUserDto(savedUser);
    }

    /*public UserDto getUserById(Long userId) {
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
    }*/

}