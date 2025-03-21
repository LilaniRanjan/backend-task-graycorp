package com.example.backend_task.controller;

import com.example.backend_task.entity.Task;
import com.example.backend_task.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/{id}")
    public ResponseEntity<Task> createTask(@PathVariable Long id) {
        Task task = taskService.createTask(id);
        return ResponseEntity.ok(task);
    }
}
