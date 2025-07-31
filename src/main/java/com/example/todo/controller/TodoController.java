package com.example.todo.controller;

import com.example.todo.dto.TodoDto;
import com.example.todo.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/todo")
public class TodoController {

    private final TodoService service;

    @Autowired
    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping
    public List<TodoDto> getTodoListByUserId(@RequestParam Long userId) {
        return service.getTodoListByUserId(userId);
    }

    @GetMapping("/{id}")
    public TodoDto getTodoById(@PathVariable Long id) {
        return service.getTodoById(id);
    }

    @PostMapping
    public TodoDto createTodo(@RequestParam Long userId, @Valid @RequestBody TodoDto todoDto) {
        return service.addTodo(userId, todoDto);
    }

    @PutMapping
    public TodoDto updateTodo(@RequestParam Long userId, @Valid @RequestBody TodoDto todoDto) {
        return service.updateTodo(userId, todoDto);
    }

    @DeleteMapping
    public void deleteTodo(@RequestParam Long userId, @RequestBody TodoDto todoDto) {
        service.deleteTodo(userId, todoDto);
    }
}
