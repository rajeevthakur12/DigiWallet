package com.DigiWallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DigiWallet.model.BankAccount;
import com.DigiWallet.model.Wallet;

@Repository
public interface BankAccountRepo extends JpaRepository<BankAccount, Integer>{
	
	public BankAccount  findByWallet(Wallet walletId);
	public BankAccount findByAccountNo(Integer accountNo);
}
