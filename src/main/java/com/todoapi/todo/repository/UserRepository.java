package com.todoapi.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.todoapi.todo.dto.UserOnlyDto;
import com.todoapi.todo.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
  @Query("SELECT new com.todoapi.todo.dto.UserOnlyDto(u.id, u.name, u.email, u.role) FROM User u")
  List<UserOnlyDto> findAllUser();
}
