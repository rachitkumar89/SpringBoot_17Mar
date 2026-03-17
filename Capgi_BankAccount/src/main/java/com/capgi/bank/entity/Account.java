package com.capgi.bank.entity;

import com.capgi.bank.entity.dto.AccountType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;
    private String accountHolderName;

    private String holderEmail;
    private String accountSecureKey;
    private Long balance;
    // private String accountType;

    private AccountType accountType;
}
