package com.example.todo.service;

import com.example.todo.dto.TodoDto;
import com.example.todo.entity.Todo;
import com.example.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<TodoDto> getTodoListByUserId(Long userId) {
        List<Todo> todos = todoRepository.findByUserId(userId);
        List<TodoDto> dtoList = new ArrayList<>();

        for (Todo todo : todos) {
            dtoList.add(convertToDto(todo));
        }

        return dtoList;
    }

    public TodoDto addTodo(Long userId, TodoDto todoDto) {
        long count = todoRepository.countByUserIdAndDueDate(userId, todoDto.getDueDate());

        if (count >= 5) {
            throw new IllegalStateException("Only 5 tasks per day allowed. Jedi discipline required.");
        }

        Todo todo = new Todo();
        todo.setUserId(userId);
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setDueDate(todoDto.getDueDate());
        todo.setActive(todoDto.isActive());
        todo.setCreateAt(LocalDateTime.now());

        return convertToDto(todoRepository.save(todo));
    }

    public void deleteTodo(Long userId, TodoDto todoDto) {
        List<Todo> todos = todoRepository.findByUserId(userId);
        for (Todo todo : todos) {
            if (todo.getId().equals(todoDto.getId())) {
                todoRepository.delete(todo);
                break;
            }
        }
    }

    public TodoDto getTodoById(Long todoId) {
        return todoRepository.findById(todoId)
                .map(this::convertToDto)
                .orElse(null);
    }

    public TodoDto updateTodo(Long userId, TodoDto todoDto) {
        return todoRepository.findById(todoDto.getId()).map(existing -> {
            if (existing.getUserId().equals(userId)) {
                existing.setTitle(todoDto.getTitle());
                existing.setDescription(todoDto.getDescription());
                existing.setDueDate(todoDto.getDueDate());
                existing.setActive(todoDto.isActive());
                Todo updated = todoRepository.save(existing);
                return convertToDto(updated);
            }
            return null;
        }).orElse(null);
    }

    private TodoDto convertToDto(Todo todo) {
        TodoDto dto = new TodoDto(
                todo.getTitle(),
                todo.getDescription(),
                todo.getDueDate(),
                todo.isActive()
        );
        dto.setId(todo.getId());
        dto.setUserId(todo.getUserId());
        return dto;
    }
}
