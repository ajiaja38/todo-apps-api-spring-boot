package com.todoapi.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.todoapi.todo.entity.User;
import com.todoapi.todo.services.UserService;
import com.todoapi.todo.utils.ResponseRest;

@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired
  UserService userService;

  @PostMapping
  public ResponseEntity<ResponseRest> createUserHandler(@RequestBody User user) {
    return ResponseEntity.created(null).body(
      new ResponseRest(
        HttpStatus.CREATED.value(),
        "Success Create User",
        this.userService.saveUser(user)
      )
    );
  }

  @GetMapping
  public ResponseEntity<ResponseRest> getAllUserhandler() {
    return ResponseEntity.ok().body(
      new ResponseRest(
        HttpStatus.OK.value(),
        "Success Get All Users",
        this.userService.getAllUsers()
      )
    );
  }

  @GetMapping("{id}")
  public ResponseEntity<ResponseRest> getUserByIdHandler(@PathVariable String id) {
    return ResponseEntity.ok().body(
      new ResponseRest(
        HttpStatus.OK.value(),
        "Success Get User By Id",
        this.userService.getUserById(id)
      )
    );
  }

  @PutMapping("{id}")
  public ResponseEntity<ResponseRest> updateUserHandler(@PathVariable String id, User user) {
    return ResponseEntity.created(null).body(
      new ResponseRest(
        HttpStatus.CREATED.value(),
        "Success Update User",
        this.userService.updateUser(id, user)
      )
    );
  }

  @DeleteMapping("{id}")
  public ResponseEntity<ResponseRest> deleteUserHandler(@PathVariable String id) {
    this.userService.deleteUser(id);
    return ResponseEntity.ok().body(
      new ResponseRest(
        HttpStatus.OK.value(),
        "Success Delete User",
        null
      )
    );
  }
}
