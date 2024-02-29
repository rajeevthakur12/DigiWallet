package com.DigiWallet.service;

import java.time.LocalDate;

import com.DigiWallet.exception.BillPaymentException;
import com.DigiWallet.exception.CustomerException;
import com.DigiWallet.exception.WalletException;
import com.DigiWallet.model.BillPayment;

import jakarta.transaction.TransactionalException;

public interface BillPaymentService {
	
	public String addBillPayment(String mobile, String Name, double amount, String billType, LocalDate paymentDate, Integer walletId, String key) throws WalletException, BillPaymentException, CustomerException, TransactionalException;

	public BillPayment viewBillPayment(String mobile, Integer walletId, String key)throws BillPaymentException, CustomerException, WalletException;
}
