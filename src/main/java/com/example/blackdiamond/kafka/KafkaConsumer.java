package com.example.blackdiamond.kafka;

import com.example.blackdiamond.objects.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "user-topic", groupId = "user-group")
    public void consume(User user) {
        System.out.println("Consumed user: " + user);
        // Here you can write logic like saving to DB, sending email, etc.
    }
}
