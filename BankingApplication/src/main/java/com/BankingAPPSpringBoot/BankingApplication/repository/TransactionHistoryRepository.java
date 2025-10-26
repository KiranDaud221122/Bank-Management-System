package com.BankingAPPSpringBoot.BankingApplication.repository;

import com.BankingAPPSpringBoot.BankingApplication.entity.TransactionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory, Long> {

    // Custom query method to get all transactions of one account
    List<TransactionHistory> findByAccountId(Long accountId);
}
