package com.netfilms.NetFilms.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "accounts")
public class AccountModel {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", updatable = false, unique = true, nullable = false)
  private UUID id;
  private String name;
  private String email;
  private String password;
  private Boolean isAdmin = false;
  private LocalDateTime created_at;
}
