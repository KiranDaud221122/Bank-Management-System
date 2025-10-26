package com.BankingAPPSpringBoot.BankingApplication.service.impl;

import com.BankingAPPSpringBoot.BankingApplication.dto.AccountDto;
import com.BankingAPPSpringBoot.BankingApplication.entity.Account;
import com.BankingAPPSpringBoot.BankingApplication.entity.TransactionHistory;
import com.BankingAPPSpringBoot.BankingApplication.mapper.AccountMapper;
import com.BankingAPPSpringBoot.BankingApplication.repository.AccountRepository;
import com.BankingAPPSpringBoot.BankingApplication.repository.TransactionHistoryRepository;
import com.BankingAPPSpringBoot.BankingApplication.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServicesImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final TransactionHistoryRepository transactionHistoryRepository;

    public AccountServicesImpl(AccountRepository accountRepository, TransactionHistoryRepository transactionHistoryRepository) {
        this.accountRepository = accountRepository;
        this.transactionHistoryRepository = transactionHistoryRepository;
    }

    // ✅ Create new account
    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    // ✅ Get account by ID
    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exist"));
        return AccountMapper.mapToAccountDto(account);
    }

    // ✅ Deposit money and record transaction
    @Override
    @Transactional
    public AccountDto deposit(Long id, double amount) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exist"));

        double totalBalance = account.getBalance() + amount;
        account.setBalance((long) totalBalance);
        accountRepository.save(account);

        TransactionHistory transaction = new TransactionHistory("DEPOSIT", (long) amount, LocalDateTime.now(), account);
        transactionHistoryRepository.save(transaction);

        return AccountMapper.mapToAccountDto(account);
    }

    // ✅ Withdraw money and record transaction
    @Override
    @Transactional
    public AccountDto withdraw(Long id, double amount) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exist"));

        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        double totalBalance = account.getBalance() - amount;
        account.setBalance((long) totalBalance);
        accountRepository.save(account);

        TransactionHistory transaction = new TransactionHistory("WITHDRAW", (long) amount, LocalDateTime.now(), account);
        transactionHistoryRepository.save(transaction);

        return AccountMapper.mapToAccountDto(account);
    }

    // ✅ Get all accounts
    @Override
    public List<AccountDto> getAllAccounts() {
        return accountRepository.findAll()
                .stream()
                .map(AccountMapper::mapToAccountDto)
                .collect(Collectors.toList());
    }

    // ✅ Delete account and related transactions (handled automatically)
    @Override
    public void deleteAccountById(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account with this ID doesn’t exist"));

        accountRepository.delete(account);
        System.out.println("✅ Account and its transactions deleted successfully!");
    }

    // ✅ Demonstrate caching (optional)
    @Override
    @Transactional
    public void demonstrateCaching(Long id) {
        System.out.println("Fetching account first time...");
        Account acc1 = accountRepository.findById(id).orElse(null);

        System.out.println("Fetching account second time...");
        Account acc2 = accountRepository.findById(id).orElse(null);
    }
}
