package com.example.todo.service;

import com.example.todo.dto.TodoDto;
import com.example.todo.entity.Todo;
import com.example.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    TodoRepository todoRepository;

    @Autowired
    TodoDto todoResponse;

    public ArrayList<TodoDto> getTodoListByUserId(Long userId){

    }

    private void addTodo(@RequestBody Long userId, TodoDto todo){
        TodoDto dto = new TodoDto(
                todo.getTitle(),
                todo.getDescription(),
                todo.getDueDate(),
                todo.isActive()
        );

        Todo todo = new Todo();

        todoRepository.save(dto);


    }

    public void deleteTodo(Long userId, TodoDto todo){

    }

    public ArrayList<Todo> getTodoById(Long todoId){

        todoRepository.findByUserId(todoId);

    }

    public void updateTodo(@RequestBody Long userId, TodoDto todo){


    }
}
