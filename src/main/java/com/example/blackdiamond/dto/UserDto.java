package com.example.blackdiamond.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
public class UserDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name = "user_name")
    @NotBlank(message = "Name is required")
    public String userName;

    @Email(message = "invalid email")
    @Column(name = "email")
    public String email;


    @Column(name = "password")
    public String password;
}
