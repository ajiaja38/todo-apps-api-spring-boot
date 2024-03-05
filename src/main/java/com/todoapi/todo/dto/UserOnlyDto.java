package com.todoapi.todo.dto;

import com.todoapi.todo.utils.RoleEnum;

import lombok.AllArgsConstructor;
import lombok.*;

@ToString
@Setter
@Getter
@AllArgsConstructor
public class UserOnlyDto {
  private String id;
  private String name;
  private String email;
  private RoleEnum role;
}
