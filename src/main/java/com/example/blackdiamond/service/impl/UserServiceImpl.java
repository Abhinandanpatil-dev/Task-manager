package com.example.blackdiamond.service.impl;

import com.example.blackdiamond.dto.UserDto;
import com.example.blackdiamond.mapper.UserMapper;
import com.example.blackdiamond.objects.User;
import com.example.blackdiamond.repository.UserRepository;
import com.example.blackdiamond.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        User user =userRepository.findById(id).orElseThrow();
       UserDto userDto =userMapper.userToUserDTO(user);

        return userDto;
    }

    @Override
    public UserDto updateUser(UserDto userDto, int id) {

        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setUserName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        User useruser = userRepository.save(user);

        UserDto userDto1=userMapper.userToUserDTO(useruser);
        return userDto1;
    }

    @Override
    public void deleteUser(int id) {
        User user=userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
         userRepository.delete(user);
    }
}
