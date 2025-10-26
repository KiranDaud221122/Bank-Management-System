package com.BankingAPPSpringBoot.BankingApplication.service;

import com.BankingAPPSpringBoot.BankingApplication.dto.AccountDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {

    abstract AccountDto createAccount(AccountDto account);

    abstract AccountDto getAccountById(Long id);

    abstract AccountDto deposit(Long id , double amount);

    abstract AccountDto withdraw(Long id , double amount);

    abstract List<AccountDto> getAllAccounts();

    abstract  void deleteAccountById(Long id);

    abstract void demonstrateCaching(Long id);

}
