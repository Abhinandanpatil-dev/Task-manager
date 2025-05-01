package com.example.blackdiamond.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {

    public int id;
    @Column(name = "user_name")

    public String userName;
    @Column(name = "email")
    public String email;
    public String password;
}
