package com.example.unifiedplatform.repository;

import com.example.unifiedplatform.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Integer> {
    Page<Task> findByOrderByIdDesc(Pageable pageable);
}
