package com.example.blackdiamond.objects;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;



@Entity
@Data
@Getter
@Setter
@Table(name = "user_admin")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "user_id")
   public int id;

    @Column(name = "user_name")
    public String userName;

    @Column(name = "email")
    public String email;

    @Column(name = "password")
    public String password;
}
