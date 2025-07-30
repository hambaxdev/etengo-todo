package com.example.todo.repository;

import com.example.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findByUserIdAndTodoId(Long userId, Long todoId);

    Long countByDueDate(LocalDate dueDate);

    List<Todo> findByUserId(Long userId);
}
