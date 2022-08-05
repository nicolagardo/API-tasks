package com.javaapi.todoapp.mapper;

import com.javaapi.todoapp.persistence.entity.Task;
import com.javaapi.todoapp.persistence.entity.TaskStatus;
import com.javaapi.todoapp.service.dto.TaskInDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TaskInDTOToTask implements IMapper<TaskInDTO, Task>{

    @Override
    public Task map(TaskInDTO in) {
        Task task = new Task();
        task.setTitle(in.getTitle());
        task.setDescription(in.getDescription());
        task.setEta(in.getEta());
        task.setCreateDate(LocalDateTime.now());
        task.setTaskStatus(TaskStatus.ON_TIME);
        return task;
    }
}
