package com.todoapi.todo.interfaces;

import java.util.List;

import com.todoapi.todo.dto.TodoOnlyDto;
import com.todoapi.todo.entity.Todo;

public interface TodoInterface {
  Todo saveTodo(Todo todo);
  List<TodoOnlyDto> getAllTodos();
  Todo getTodoById(String id);
  Todo updateTodo(String id, Todo todo);
  void deleteTodo(String id);
}
