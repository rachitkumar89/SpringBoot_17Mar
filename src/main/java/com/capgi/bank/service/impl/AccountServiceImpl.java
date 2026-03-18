package com.capgi.bank.service.impl;
import com.capgi.bank.Exception.AccountNotFoundException;
import com.capgi.bank.config.CustomMapper;
import com.capgi.bank.entity.Account;
import com.capgi.bank.entity.dto.AccountDto;
import com.capgi.bank.entity.dto.AccountResponseDto;
import com.capgi.bank.repository.AccountRepository;
import com.capgi.bank.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;
//    private  final AccountDto accountDto;
    @Override
    public void createAccount(AccountDto accountDto) {
        Account account= CustomMapper.mapAccountDtoToAccount(accountDto, new Account());
//        Account account = new Account();
//        account.setAccountHolderName(accountDto.getAccountHolderName());
//        account.setBalance(accountDto.getBalance());
//        account.setAccountType(accountDto.getAccountType());
//        account.setAccountSecureKey(accountDto.getAccountSecureKey());
//        account.setHolderEmail(accountDto.getHolderEmail());

          accountRepository.save(account);

    }
    @Override
    public AccountResponseDto getAccountById(Integer id){
        Optional<Account> account=accountRepository.findById(id);
        AccountResponseDto accountDto= modelMapper.map(account,AccountResponseDto.class);
        return accountDto;
    }

    @Override
    public List<AccountResponseDto> findAll() {
        List<Account> accountList = accountRepository.findAll();
        List<AccountResponseDto> accountResponseDtoList = accountList.stream()
                .map(account -> modelMapper.map(account, AccountResponseDto.class))
                .toList();
        return accountResponseDtoList;
    }

    @Override
    public AccountResponseDto findById(Integer id){
        Account account=accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account not found for your Id: "+id));
    return  modelMapper.map(account,AccountResponseDto.class);
    }

    @Override
    public AccountResponseDto updateAccount(Integer id, AccountDto accountDto){
        Account account = accountRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Account not found"));
        modelMapper.getConfiguration().setSkipNullEnabled(false);
        modelMapper.map(accountDto,account);
        Account updatedAccount = accountRepository.save(account);
        return modelMapper.map(updatedAccount,AccountResponseDto.class);
    }

    @Override
    public AccountResponseDto partialUpdateAccount(Integer id, AccountDto accountDto) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        // ✅ First enable skip null
        modelMapper.getConfiguration().setSkipNullEnabled(true);

        // ✅ Then map
        modelMapper.map(accountDto, account);

        Account patchAccount = accountRepository.save(account);

        return modelMapper.map(patchAccount, AccountResponseDto.class);
    }


}
