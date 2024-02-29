package com.DigiWallet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DigiWallet.model.Customer;
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	
    public Customer findByMobileNumber(String mobileNumber);

}
