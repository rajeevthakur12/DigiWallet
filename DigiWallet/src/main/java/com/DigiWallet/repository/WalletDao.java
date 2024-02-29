package com.DigiWallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DigiWallet.model.Customer;
import com.DigiWallet.model.Wallet;

@Repository
public interface WalletDao extends JpaRepository<Wallet,Integer> {

	 public Wallet findByCustomer(Customer customer);

}