package com.netfilms.NetFilms.dto;

import com.netfilms.NetFilms.model.AccountModel;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
public class AccountDto {
  @NotBlank
  private String name;
  @NotBlank
  @Email
  private String email;
  @NotBlank
  private String password;
}
