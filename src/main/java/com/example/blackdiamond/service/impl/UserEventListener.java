package com.example.blackdiamond.service.impl;

import com.example.blackdiamond.events.TaskEvent;
import org.springframework.kafka.annotation.KafkaListener;

public class UserEventListener {

    @KafkaListener(topics = "user-events", groupId = "black-diamond-group", containerFactory = "kafkaListenerContainerFactory")
    public void handleEvent(TaskEvent event) {
        System.out.println("Processing: " + event);
    }
}
