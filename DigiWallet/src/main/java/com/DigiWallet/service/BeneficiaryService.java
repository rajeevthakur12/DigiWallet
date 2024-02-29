package com.DigiWallet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.DigiWallet.exception.BeneficiaryException;
import com.DigiWallet.exception.CustomerException;
import com.DigiWallet.exception.WalletException;
import com.DigiWallet.model.Beneficiary;
import com.DigiWallet.model.BeneficiaryDTO;

@Service
public interface BeneficiaryService {

	public Beneficiary addBeneficiary(Beneficiary beneficiary, String key) throws BeneficiaryException, CustomerException, WalletException;
	
	public Beneficiary deleteBeneficiary(String key, BeneficiaryDTO beneficiaryDTO) throws BeneficiaryException, CustomerException;
	
	public Beneficiary viewBeneficiary(String beneficiaryName, String key) throws BeneficiaryException, CustomerException;

	public List<Beneficiary> viewAllBeneficiary(String key) throws BeneficiaryException, CustomerException;
	
	
}
