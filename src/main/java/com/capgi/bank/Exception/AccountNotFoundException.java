package com.capgi.bank.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(String exceptionMessage) {
        super(exceptionMessage);
    }

}
