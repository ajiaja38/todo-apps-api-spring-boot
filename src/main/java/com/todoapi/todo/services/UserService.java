package com.todoapi.todo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.todoapi.todo.dto.UserOnlyDto;
import com.todoapi.todo.entity.User;
import com.todoapi.todo.interfaces.UserInterface;
import com.todoapi.todo.repository.UserRepository;

@Service
public class UserService implements UserInterface {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;
  
  @Override
  public User saveUser(User user) {
    user.setPassword(this.passwordEncoder.encode(user.getPassword()));
    return this.userRepository.save(user);
  }

  @Override
  public List<UserOnlyDto> getAllUsers() {
    return this.userRepository.findAllUser();
  }

  @Override
  public User getUserById(String id) {
    return this.userRepository.findById(id).orElseThrow(
      () -> new RuntimeException("User not found with id: " + id)
    );
  }

  @Override
  public User updateUser(String id, User user) {
    User existingUser = this.userRepository.findById(id).orElseThrow(
      () -> new RuntimeException("User not found with id: " + id)
    );
    
    existingUser.setName(user.getName());
    existingUser.setEmail(user.getEmail());
    existingUser.setRole(user.getRole());
    
    return this.userRepository.save(existingUser);
  }

  @Override
  public void deleteUser(String id) {
    if (!this.userRepository.existsById(id)) {
      throw new RuntimeException("User not found with id: " + id);
    }
    
    this.userRepository.deleteById(id);
  }
  
}
