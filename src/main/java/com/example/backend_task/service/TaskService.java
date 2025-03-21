package com.example.backend_task.service;

import com.example.backend_task.entity.Task;
import com.example.backend_task.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class TaskService {
    
    private final TaskRepository taskRepository;
    private final RestTemplate restTemplate;

    public TaskService(TaskRepository taskRepository, RestTemplate restTemplate) {
        this.taskRepository = taskRepository;
        this.restTemplate = restTemplate;
    }

    public Task createTask(Long taskId) {
        // Check if task already exists in the database
        Optional<Task> existingTask = taskRepository.findById(taskId);
        if (existingTask.isPresent()) {
            return existingTask.get(); 
        }

        // Fetch task details from the third-party API
        String apiUrl = "https://jsonplaceholder.typicode.com/todos/" + taskId;
        Task fetchedTask = restTemplate.getForObject(apiUrl, Task.class);

        if (fetchedTask != null) {
            fetchedTask.setId(taskId);  
            return taskRepository.save(fetchedTask); 
        }

        throw new RuntimeException("Task not found in external API");
    }
    
    
    
}
