package com.DigiWallet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.DigiWallet.exception.BankAccountException;
import com.DigiWallet.exception.CustomerException;
import com.DigiWallet.model.BankAccount;
import com.DigiWallet.model.Wallet;
import com.DigiWallet.model.dto.BankAccountDTO;
@Service
public interface BankAccountService {
	
	public Wallet addAccount(String key,BankAccountDTO bankAccountDTO) throws BankAccountException,CustomerException;
	
	public Wallet removeAccount(String key,Integer accountNo) throws BankAccountException, CustomerException;
	
	public BankAccount viewAccount(String key, Integer accountNo) throws BankAccountException, CustomerException;
	
	public List<BankAccount> viewAllAccounts(String key) throws BankAccountException, CustomerException;

}
