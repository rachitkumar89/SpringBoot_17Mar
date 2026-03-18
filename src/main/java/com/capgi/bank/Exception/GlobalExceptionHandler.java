package com.capgi.bank.Exception;

import com.capgi.bank.entity.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleAccountNotFoundException(AccountNotFoundException accounrNotFoundException,WebRequest webRequest){
        ErrorResponseDto errorResponseDto=new ErrorResponseDto(
                webRequest.getDescription(false),
                HttpStatus.BAD_REQUEST,
                accounrNotFoundException.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorResponseDto,HttpStatus.BAD_REQUEST);
    }
}
