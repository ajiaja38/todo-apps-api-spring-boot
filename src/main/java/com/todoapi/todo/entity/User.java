package com.todoapi.todo.entity;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import com.todoapi.todo.utils.RoleEnum;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "mst_user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {

  @Id
  @Column(name = "user_id")
  private String id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false, unique = true)
  private String email;

  @Column
  private String password;

  @Enumerated(EnumType.STRING)
  private RoleEnum role = RoleEnum.USER;

  private Date createdAt = new Date();

  private Date updatedAt = createdAt;

  @OneToMany(mappedBy = "user")
  private Set<Todo> todos;

  @PrePersist
  public void prefixId() {
    this.id = "user-" + UUID.randomUUID().toString();
  }
}
