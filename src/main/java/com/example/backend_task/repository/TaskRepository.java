package com.example.backend_task.repository;

import com.example.backend_task.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    
    // Custom method to get tasks by completion status
    List<Task> findByCompleted(Boolean completed);
}
