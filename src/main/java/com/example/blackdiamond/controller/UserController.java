package com.example.blackdiamond.controller;

import com.example.blackdiamond.dto.UserDto;
import com.example.blackdiamond.kafka.KafkaProducer;
import com.example.blackdiamond.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    private KafkaProducer kafkaProducer;


//    @PostMapping("/save")
//    public String createUser( @RequestBody UserDto userDto) {
//        UserDto response = userService.createUser(userDto);
////        return new ResponseEntity<>(response, HttpStatus.OK);
//        kafkaProducer.sendMessage(userDto);
//        return "User creation event sent to Kafka!"+userDto;
//    }

    @PostMapping("/save")
    public ResponseEntity<Map<String, Object>> createUser(@RequestBody UserDto userDto) {
        UserDto response = userService.createUser(userDto);
        kafkaProducer.sendMessage(userDto);

        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("message", "User creation event sent to Kafka!");
        responseBody.put("user", response);

        return new ResponseEntity<>(responseBody, HttpStatus.OK);
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

    @DeleteMapping("deleteUser/{id}")

    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
//       return new ResponseEntity<>(Map.of("message,user deleted sucssesfully"),HttpStatus.OK);
        System.out.println("user deleted with id" + id);
        return new ResponseEntity<>(Map.of("message", "user deleted sucssesfully " + id), HttpStatus.OK);


    }
}
