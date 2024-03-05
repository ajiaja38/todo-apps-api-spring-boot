package com.todoapi.todo.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class ResponseRest {
  private int code;

  private String message;

  private Object data;
}
