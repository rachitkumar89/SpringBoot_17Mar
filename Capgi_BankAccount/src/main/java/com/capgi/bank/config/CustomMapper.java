package com.capgi.bank.config;

import com.capgi.bank.entity.Account;
import com.capgi.bank.entity.dto.AccountDto;
import com.capgi.bank.entity.dto.AccountResponseDto;

public class CustomMapper {
    public static Account mapAccountDtoToAccount(AccountDto accountDto, Account account){
        account.setBalance(accountDto.getBalance());
        account.setAccountType(accountDto.getAccountType());
        account.setHolderEmail(accountDto.getHolderEmail());
        account.setAccountSecureKey(accountDto.getAccountSecureKey());
        account.setAccountHolderName(accountDto.getAccountHolderName());
        return account;
    }
}
