package com.example.todo.repository;

import com.example.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findByUserIdAndId(Long userId, Long id);

    List<Todo> findByUserId(Long userId);

    long countByUserIdAndDueDate(Long userId, LocalDate dueDate);
}
