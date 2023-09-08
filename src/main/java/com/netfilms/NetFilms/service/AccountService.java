package com.netfilms.NetFilms.service;

import com.netfilms.NetFilms.model.AccountModel;
import com.netfilms.NetFilms.repository.AccountRepository;
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
    return accountRepository.save(accountModel);
  }
}
