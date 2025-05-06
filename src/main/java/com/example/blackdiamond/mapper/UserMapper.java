package com.example.blackdiamond.mapper;

import com.example.blackdiamond.dto.UserDto;
import com.example.blackdiamond.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto userToUserDTO(User user);
    User userDTOToUser(UserDto userDTO);
}
