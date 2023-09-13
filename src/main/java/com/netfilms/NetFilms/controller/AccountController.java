package com.netfilms.NetFilms.controller;

import com.netfilms.NetFilms.dto.AccountDto;
import com.netfilms.NetFilms.error.CustomExeption;
import com.netfilms.NetFilms.model.AccountModel;
import com.netfilms.NetFilms.service.AccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/account")
public class AccountController {
  private final AccountService accountService;

  public AccountController(AccountService accountService) {
    this.accountService = accountService;
  }

  @PostMapping
  public @ResponseBody ResponseEntity<Object> creatingAccount(@RequestBody @Valid AccountDto accountDto) {
    AccountModel accountModel = new AccountModel();

    BeanUtils.copyProperties(accountDto, accountModel);
    accountModel.setCreated_at(LocalDateTime.now());

    return ResponseEntity.status(HttpStatus.CREATED).body(accountService.save(accountModel));
  }
}
