package com.todoapi.todo.dto;

import java.util.Date;

import com.todoapi.todo.utils.RoleEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class UserOnlyByIdDto {
  private String id;
  private String name;
  private String email;
  private RoleEnum role;
  private Date createdAt;
  private Date updatedAt;
}
