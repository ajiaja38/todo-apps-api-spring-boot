package com.todoapi.todo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoapi.todo.dto.TodoOnlyDto;
import com.todoapi.todo.entity.Todo;
import com.todoapi.todo.entity.User;
import com.todoapi.todo.interfaces.TodoInterface;
import com.todoapi.todo.repository.TodoRepository;

@Service
public class TodoService implements TodoInterface {
  @Autowired
  private TodoRepository todoRepository;

  @Autowired
  private UserService userService;

  @Override
  public Todo saveTodo(Todo todo) {
    User user = this.userService.getUserById("user-0a5fbe73-e456-4baf-9a04-bcf591b9277d");
    todo.setUser(user);
    return this.todoRepository.save(todo);
  }

  @Override
  public List<TodoOnlyDto> getAllTodos() {
    return this.todoRepository.findAllTodo();
  }

  @Override
  public Todo getTodoById(String id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getTodoById'");
  }

  @Override
  public Todo updateTodo(String id, Todo todo) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'updateTodo'");
  }

  @Override
  public void deleteTodo(String id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteTodo'");
  }
  
}
