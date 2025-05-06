package com.example.blackdiamond.service;

import com.example.blackdiamond.dto.UserDto;

import java.util.List;

public interface UserService {


    UserDto createUser(UserDto userDto);

    List<UserDto>  getAllUsers();

    UserDto getUserById(int id);

    UserDto updateUser(UserDto userDto,int id);

    void deleteUser(int id);
}
