package com.netfilms.NetFilms.service;

import com.netfilms.NetFilms.error.CustomExeption;
import com.netfilms.NetFilms.model.AccountModel;
import com.netfilms.NetFilms.repository.AccountRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AccountService {
  private final AccountRepository accountRepository;

  public AccountService(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  @Transactional
  public AccountModel save(AccountModel accountModel) {
    if (accountRepository.existsByEmail(accountModel.getEmail())) {
      throw new CustomExeption("Account already exists!");
    }

    if (accountModel.getPassword().length() < 4) {
      throw new CustomExeption("Password too short!");
    }

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    String passwordEncoded = bCryptPasswordEncoder.encode(accountModel.getPassword());
    accountModel.setPassword(passwordEncoded);

    return accountRepository.save(accountModel);
  }
}
