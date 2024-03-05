package com.todoapi.todo.dto;

import java.util.Date;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class TodoOnlyDto {
  private String id;
  private String title;
  private String description;
  private String author;
  private Date createdAt;
  private Date updatedAt;
}
