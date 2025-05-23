package com.example.blackdiamond.service.impl;

import com.example.blackdiamond.dto.UserDto;
import com.example.blackdiamond.exception.UserNotFoundException;
import com.example.blackdiamond.mapper.UserMapper;
import com.example.blackdiamond.entities.User;
import com.example.blackdiamond.repository.UserRepository;
import com.example.blackdiamond.service.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;


    @Autowired
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    @Override
    public UserDto createUser(UserDto userDto) {
        User user = userMapper.userDTOToUser(userDto);
        userRepository.save(user);
        return userDto;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = users.stream().map(userMapper::userToUserDTO).toList();
        return userDtos;
    }

    @Override
    public UserDto getUserById(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("user not found with ", id));
        UserDto userDto = userMapper.userToUserDTO(user);
        return userDto;
    }

    @Override
    public UserDto updateUser(UserDto userDto, int id) {

        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("id", id));
        user.setUserName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        User useruser = userRepository.save(user);

//        UserDto userDto1=userMapper.userToUserDTO(useruser);
        return userMapper.userToUserDTO(useruser);
    }

    @Override
    public void deleteUser(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found", id));
        userRepository.delete(user);
        log.info("user deleted successfully {}", id);

    }
}
