package com.aiylbank.demo.model.task.service.dto;

import com.aiylbank.demo.model.task.entity.Status;
import org.springframework.stereotype.Component;

@Component
public class TaskDto {
    private Long id;
    private String description;
    private Status status;
}
