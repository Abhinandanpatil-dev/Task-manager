package com.example.blackdiamond.kafka;

import com.example.blackdiamond.dto.UserDto;
import com.example.blackdiamond.mapper.UserMapper;
import com.example.blackdiamond.objects.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    private final UserMapper userMapper;


    private static final String TOPIC = "user-topic";

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    public KafkaProducer(UserMapper userMapper, KafkaTemplate<String, User> kafkaTemplate) {
        this.userMapper = userMapper;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(UserDto user) {
        User user1=userMapper.userDTOToUser(user);
        kafkaTemplate.send(TOPIC, user1);
    }
}
