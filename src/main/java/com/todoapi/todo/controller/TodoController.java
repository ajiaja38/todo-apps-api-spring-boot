package com.todoapi.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todoapi.todo.entity.Todo;
import com.todoapi.todo.services.TodoService;
import com.todoapi.todo.utils.ResponseRest;

@RestController
@RequestMapping("/todos")
public class TodoController {
  @Autowired
  private TodoService todoService;

  @PostMapping
  public ResponseEntity<ResponseRest> createTodoHandler(@RequestBody Todo todo) {
    return ResponseEntity.created(null).body(
      new ResponseRest(
        HttpStatus.CREATED.value(),
        "Success Create Todo",
        this.todoService.saveTodo(todo)
      )
    );
  }

  @GetMapping
  public ResponseEntity<ResponseRest> getAllTodoHandler() {
    return ResponseEntity.ok().body(
      new ResponseRest(
        HttpStatus.OK.value(),
        "Success Get All Todos",
        this.todoService.getAllTodos()
      )
    );
  }
}
