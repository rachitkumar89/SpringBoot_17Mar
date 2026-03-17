package com.capgi.bank.controller;

import com.capgi.bank.constants.AccountConstant;
import com.capgi.bank.entity.dto.AccountDto;
import com.capgi.bank.entity.dto.AccountResponseDto;
import com.capgi.bank.entity.dto.ResponseDto;
import com.capgi.bank.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor

public class AccountController {
    private final AccountService accountService;

    @PostMapping("/create")
    public  ResponseEntity<ResponseDto> createAccount(@RequestBody AccountDto accountDto){
        accountService.createAccount(accountDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(AccountConstant.STATUS_200,AccountConstant.MESSAGE_201,null));
    }
    @GetMapping("findid/{id}")
    public ResponseEntity<ResponseDto> getAccountById(@PathVariable Integer id){
        AccountResponseDto acountDto=accountService.getAccountById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AccountConstant.STATUS_200,AccountConstant.MESSAGE_200,acountDto));
    }

    @GetMapping("/findall")
    public ResponseEntity<ResponseDto> findAll(){
        List<AccountResponseDto> accountResponseDtoList = accountService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(AccountConstant.STATUS_200,AccountConstant.Message_get,accountResponseDtoList));
    }

}
