package com.spring.TODO_management_project.repository;

import com.spring.TODO_management_project.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
