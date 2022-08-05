package com.javaapi.todoapp.persistence.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private  String title;
    private String description;
    private LocalDateTime CreateDate;
    private LocalDateTime eta;
    private boolean finished;
    private TaskStatus taskStatus;
}
