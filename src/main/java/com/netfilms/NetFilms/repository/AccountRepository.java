package com.netfilms.NetFilms.repository;

import com.netfilms.NetFilms.model.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountModel, Long> {
}
