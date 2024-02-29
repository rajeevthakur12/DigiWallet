package com.DigiWallet.service;

import jakarta.validation.constraints.AssertFalse.List;

import org.springframework.stereotype.Service;

import com.DigiWallet.exception.BankAccountException;
import com.DigiWallet.exception.BeneficiaryException;
import com.DigiWallet.exception.CustomerException;
import com.DigiWallet.exception.TransactionException;
import com.DigiWallet.exception.WalletException;
import com.DigiWallet.model.Customer;
import com.DigiWallet.model.dto.BankAccountDTO;

import java.math.BigDecimal;

@Service
public interface WalletService {

    public Customer createAccount(Customer customer,BigDecimal bigDecimal) throws CustomerException;

    public BigDecimal showBalance(String mobileNumber,String key) throws CustomerException;
    
    public String fundTransfer(String sourceMobileNumber, String targetMobileNumber, BigDecimal amount, String key) throws WalletException, BeneficiaryException, CustomerException;
    
    public String depositAmount(Integer accountNo,BigDecimal amount, String key) throws BankAccountException, WalletException, CustomerException, TransactionException;
    
    public Customer customerDatails(String mobileNumber,String key) throws CustomerException;

    public Customer updateAccount(Customer customer,String key)throws CustomerException;
}