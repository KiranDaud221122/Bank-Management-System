package com.BankingAPPSpringBoot.BankingApplication.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "accounts")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String accountHolderName;
	private Long balance;

	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference  // ← Add this
	private List<TransactionHistory> transactions = new ArrayList<>();

	public Account() {}

	public Account(Long id, String accountHolderName, Long balance) {
		this.id = id;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
	}

	// Getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public List<TransactionHistory> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<TransactionHistory> transactions) {
		this.transactions = transactions;
	}
}
