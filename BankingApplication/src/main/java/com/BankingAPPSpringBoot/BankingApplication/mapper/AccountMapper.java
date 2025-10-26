package com.BankingAPPSpringBoot.BankingApplication.mapper;

import com.BankingAPPSpringBoot.BankingApplication.dto.AccountDto;
import com.BankingAPPSpringBoot.BankingApplication.entity.Account;

public class AccountMapper {

    public static Account mapToAccount(AccountDto accountDto) {
        Long balance = accountDto.getBalance() != null ? accountDto.getBalance() : 0L;
        return new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                balance
        );
    }

    public static AccountDto mapToAccountDto(Account account) {
        // Safe null handling
        Long balance = account.getBalance() != null ? account.getBalance() : 0L;
        return new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                balance
        );
    }
}
