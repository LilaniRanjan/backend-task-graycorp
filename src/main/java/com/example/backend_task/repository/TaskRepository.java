package com.example.backend_task.repository;

import com.example.backend_task.entity.Task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    
    List<Task> findByCompleted(Boolean completed);
    
    Page<Task> findAll(Pageable pageable);
}
