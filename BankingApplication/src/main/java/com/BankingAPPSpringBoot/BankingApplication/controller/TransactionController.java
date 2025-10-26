package com.BankingAPPSpringBoot.BankingApplication.controller;

import com.BankingAPPSpringBoot.BankingApplication.entity.TransactionHistory;
import com.BankingAPPSpringBoot.BankingApplication.repository.TransactionHistoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionHistoryRepository transactionHistoryRepository;

    public TransactionController(TransactionHistoryRepository transactionHistoryRepository) {
        this.transactionHistoryRepository = transactionHistoryRepository;
    }

    @GetMapping("/accounts/{accountId}")
    public List<TransactionHistory> getTransactionByAccount(@PathVariable Long accountId) {
        return transactionHistoryRepository.findByAccountId(accountId);
    }
}
