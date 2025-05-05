package com.example.blackdiamond.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@NoArgsConstructor
public class UserDto {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @Column(name = "user_name")

    public String userName;
    @Column(name = "email")
    public String email;
    @Column(name = "password")

    public String password;
}
