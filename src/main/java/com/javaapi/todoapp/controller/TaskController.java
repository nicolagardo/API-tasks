package com.javaapi.todoapp.controller;

import com.javaapi.todoapp.persistence.entity.Task;
import com.javaapi.todoapp.persistence.entity.TaskStatus;
import com.javaapi.todoapp.service.TaskService;
import com.javaapi.todoapp.service.dto.TaskInDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @PostMapping
    public Task createTask(@RequestBody TaskInDTO taskInDTO) {
        return this.taskService.createTask(taskInDTO);

    }
    @GetMapping
    public List<Task> encuentraAll(){
        return this.taskService.getAll();
    }
    @GetMapping("/status/{status}")
    public List<Task> findAllByStatus(@PathVariable ("status")TaskStatus taskStatus) {
        return this.taskService.getAll();
    }

    @PatchMapping("/mark_as_finished/{id}")
    public ResponseEntity<Void> markTasAsFinished(@PathVariable("id") Long id) {

        this.taskService.upadateTaskFinished(id);
        return ResponseEntity.noContent().build();

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {

        this.taskService.deleteTask(id);
        return ResponseEntity.noContent().build();

    }




}
