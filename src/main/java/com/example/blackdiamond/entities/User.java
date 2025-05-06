package com.example.blackdiamond.entities;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "user_admin")
public class User {


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
