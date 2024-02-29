package com.DigiWallet.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DigiWallet.exception.BillPaymentException;
import com.DigiWallet.exception.CustomerException;
import com.DigiWallet.exception.WalletException;
import com.DigiWallet.model.BillPayment;
import com.DigiWallet.repository.BillPaymentRepository;

import jakarta.transaction.TransactionalException;

@Service
public class BillPaymentServiceImpl implements BillPaymentService{

	@Autowired
	private BillPaymentRepository billPaymentRepo;
	
	
	
	
	@Override
	public String addBillPayment(String mobile, String Name, double amount, String billType, LocalDate paymentDate,
			Integer walletId, String key)
			throws WalletException, BillPaymentException, CustomerException, TransactionalException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BillPayment viewBillPayment(String mobile, Integer walletId, String key)
			throws BillPaymentException, CustomerException, WalletException {
		// TODO Auto-generated method stub
		return null;
	}

}
