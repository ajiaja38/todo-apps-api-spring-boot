package com.todoapi.todo.entity;

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "mst_todo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Todo {
  @Id
  @Column(name = "todo_id")
  private String id;

  @Column(nullable = false)
  private String title;
  
  private String description;

  private Date createdAt = new Date();

  private Date updatedAt = createdAt;

  @ManyToOne
  @JoinColumn(name = "user_id")
  @JsonIgnore
  private User user;

  @PrePersist
  public void prefixId() {
    this.id = "todo-" + UUID.randomUUID().toString();
  }
}
