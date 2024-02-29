package com.DigiWallet.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.DigiWallet.exception.CustomerException;
import com.DigiWallet.exception.TransactionException;
import com.DigiWallet.exception.WalletException;
import com.DigiWallet.model.Transaction;
@Service
public interface TransactionService {
	
	
	   public Transaction addTransaction(Transaction transaction) throws TransactionException,WalletException;

	   public List<Transaction> findByWallet(String key) throws TransactionException, WalletException, CustomerException;

	   public Transaction findByTransactionId(String key, Integer transactionId)throws TransactionException, CustomerException;

	   public List<Transaction> findByTransactionType(String key, String transactionType) throws TransactionException,CustomerException;

	   public List<Transaction> viewTransactionBetweenDate(String key, LocalDate startDate, LocalDate endDate) throws TransactionException,CustomerException;

	   public List<Transaction> viewAllTransaction()throws TransactionException;

 

}
