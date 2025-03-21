package com.example.backend_task.service;

import com.example.backend_task.entity.Task;
import com.example.backend_task.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {
    
    private final TaskRepository taskRepository;
    private final RestTemplate restTemplate;

    public TaskService(TaskRepository taskRepository, RestTemplate restTemplate) {
        this.taskRepository = taskRepository;
        this.restTemplate = restTemplate;
    }
    
//    Create Task
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
    
    
    
//    Get a Task by it;s Id
    public Task getTaskById(Long taskId) {
        return taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found with ID: " + taskId));
    }

//    Get All Task
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    
//    Delete a task by Id
    public void deleteTask(Long taskId) {
        if (!taskRepository.existsById(taskId)) {
            throw new RuntimeException("Task not found with ID: " + taskId);
        }
        taskRepository.deleteById(taskId);
    }
    
//    Get Tasks by Completion Status
    public Map<String, List<Task>> getTasksGroupedByCompletionStatus() {
        List<Task> tasks = taskRepository.findAll();

        return tasks.stream()
                .collect(Collectors.groupingBy(task -> task.isCompleted() ? "Completed" : "Pending"));
    }

    
    
}
