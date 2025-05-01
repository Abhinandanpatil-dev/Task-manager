package com.example.blackdiamond.controller;

import com.example.blackdiamond.dto.UserDto;
import com.example.blackdiamond.objects.User;
import com.example.blackdiamond.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @PostMapping("/save")
    public ResponseEntity<UserDto> createUser( @RequestBody UserDto userDto) {
        UserDto response = userService.createUser(userDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getUser")

    public ResponseEntity<List<UserDto>> getUser(UserDto user){
        List<UserDto>  user1= userService.getAllUsers();
        return new ResponseEntity<>(user1,HttpStatus.OK);
    }

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable int id){
        System.out.println("=========================="+id);
        UserDto userDto =userService.getUserById(id);
        return ResponseEntity.ok(userDto);
    }

    @PutMapping("updateUser/{id}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,@PathVariable int id){

        UserDto dto =userService.updateUser(userDto,id);

        return new  ResponseEntity<>(dto,HttpStatus.OK);

    }
}
