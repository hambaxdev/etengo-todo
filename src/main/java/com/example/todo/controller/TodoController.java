package com.example.todo.controller;

import com.example.todo.dto.TodoDto;
import com.example.todo.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/todo")
public class TodoController {

    TodoService service;

    @GetMapping
    public ArrayList<TodoDto> getTodoListByUserid(@Valid Long userId){
        return service.getTodoListByUserId(userId);
    }
}
