package com.capgi.bank.entity.dto;

import lombok.Data;

@Data
public class AccountDto {
    private Long balance;
    private AccountType accountType;

    private String holderEmail;

    private String accountSecureKey;

    private String accountHolderName;
}
