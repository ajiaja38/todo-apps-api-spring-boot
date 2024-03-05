package com.todoapi.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.todoapi.todo.dto.TodoOnlyDto;
import com.todoapi.todo.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, String> {  
  @Query("SELECT new com.todoapi.todo.dto.TodoOnlyDto(t.id, t.title, t.description, u.name, t.createdAt, t.updatedAt) FROM Todo t JOIN t.user u")
  List<TodoOnlyDto> findAllTodo();
}
