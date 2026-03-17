package com.capgi.bank.entity.dto;

import lombok.Data;

@Data
public class AccountResponseDto {
    private Long accountId;
    private Long balance;
    private AccountType accountType;

    private  String accountHolderName;

}
