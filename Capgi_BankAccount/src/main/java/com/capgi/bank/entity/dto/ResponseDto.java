package com.capgi.bank.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDto {
    private String statuseCode;
    private String statusMessage;
    private Object object;
}
