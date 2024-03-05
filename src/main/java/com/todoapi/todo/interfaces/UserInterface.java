package com.todoapi.todo.interfaces;

import java.util.List;

import com.todoapi.todo.dto.UserOnlyDto;
import com.todoapi.todo.entity.User;

public interface UserInterface {
  User saveUser(User user);
  List<UserOnlyDto> getAllUsers();
  User getUserById(String id);
  User updateUser(String id, User user);
  void deleteUser(String id);
}
