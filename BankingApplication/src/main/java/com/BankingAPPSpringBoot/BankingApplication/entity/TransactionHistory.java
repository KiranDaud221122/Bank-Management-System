package com.BankingAPPSpringBoot.BankingApplication.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction_history")
public class TransactionHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String transactionType;
    private double amount;
    private LocalDateTime localDateTime;

    @ManyToOne
    @JoinColumn(name = "account_id")
    @JsonBackReference  // ← Add this
    private Account account;

    public TransactionHistory() {}

    public TransactionHistory(String transactionType, long amount, LocalDateTime localDateTime, Account account) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.localDateTime = localDateTime;
        this.account = account;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTransactionType() { return transactionType; }
    public void setTransactionType(String transactionType) { this.transactionType = transactionType; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public LocalDateTime getLocalDateTime() { return localDateTime; }
    public void setLocalDateTime(LocalDateTime localDateTime) { this.localDateTime = localDateTime; }
    public Account getAccount() { return account; }
    public void setAccount(Account account) { this.account = account; }
}
