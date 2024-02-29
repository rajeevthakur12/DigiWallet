package com.DigiWallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DigiWallet.model.BillPayment;

public interface BillPaymentRepository extends JpaRepository<BillPayment, Integer>{

}
