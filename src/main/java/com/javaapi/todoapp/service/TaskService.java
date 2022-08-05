package com.javaapi.todoapp.service;

import com.javaapi.todoapp.ToDoAppApplication;
import com.javaapi.todoapp.exceptions.ToDoExceptions;
import com.javaapi.todoapp.mapper.TaskInDTOToTask;
import com.javaapi.todoapp.persistence.entity.Task;
import com.javaapi.todoapp.persistence.entity.TaskStatus;
import com.javaapi.todoapp.persistence.repository.TaskRepository;
import com.javaapi.todoapp.service.dto.TaskInDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository repository;
    private final TaskInDTOToTask mapper;

    public TaskService(TaskRepository repository, TaskInDTOToTask mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Task createTask(TaskInDTO taskInDTO) {
        Task task = mapper.map(taskInDTO);
        return  this.repository.save(task);

    }
    public List<Task> getAll() {
        return this.repository.findAll();
    }
    public List<Task> findAllByTaskStatus(TaskStatus taskStatus) {
        return this.repository.findAllByTaskStatus(taskStatus);
    }
    @Transactional
    public void upadateTaskFinished(Long id) {
        Optional<Task> optionalTask = this.repository.findById(id);
        if (optionalTask.isEmpty()) {
        throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.repository.markTaskFinished(id);
    }
    public void deleteTask(Long id) {
        Optional<Task> optionalTask = this.repository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.repository.deleteById(id);
    }
}
