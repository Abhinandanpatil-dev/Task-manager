package com.example.blackdiamond.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString

public class TaskEvent {

    private String userId;
    private String action;
    private String timestamp;
}
