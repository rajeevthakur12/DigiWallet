package com.DigiWallet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DigiWallet.exception.BeneficiaryException;
import com.DigiWallet.exception.CustomerException;
import com.DigiWallet.exception.WalletException;
import com.DigiWallet.model.Beneficiary;
import com.DigiWallet.model.BeneficiaryDTO;
import com.DigiWallet.model.Customer;
import com.DigiWallet.model.CustomerUserSession;
import com.DigiWallet.model.Wallet;
import com.DigiWallet.repository.BeneficiaryRepository;
import com.DigiWallet.repository.CurrRepo;
import com.DigiWallet.repository.CustomerDao;
import com.DigiWallet.repository.CustomerRepo;
import com.DigiWallet.repository.WalletDao;
import com.DigiWallet.repository.WalletRepo;

@Service
public class BeneficiaryServiceImpl implements BeneficiaryService{

	@Autowired
	private BeneficiaryRepository beneficiaryRepo;
	
	@Autowired
	private CurrRepo currRepo;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private WalletRepo walletRepo;
	
	@Autowired
	private WalletDao walletDao;
	
	/*=============================================== Add Benificiary =================================================*/
	
	@Override
	public Beneficiary addBeneficiary(Beneficiary beneficiary, String key)
			throws BeneficiaryException, CustomerException, WalletException {
		
		CustomerUserSession customerUserSession = currRepo.findByUuid(key);
		
		if(customerUserSession==null) {
			throw new CustomerException("Customer is not logged in!");
		}
		
		Optional<Customer> cust = customerDao.findById(customerUserSession.getUserId());
		
		if(!cust.isPresent()) {
			throw new CustomerException("Benificiary is not registered in this app!");
		}
		
		Optional<Wallet> wallet = walletDao.findById(beneficiary.getWallet().getWalletId());
		
		if(!wallet.isPresent()) {
			throw new WalletException("The user is Invalid!");
		}
		
		Customer customer = wallet.get().getCustomer();
		
		Boolean con = beneficiary.getWallet().getWalletId()==beneficiary.getWallet().getCustomer().getCustomerId();
		
		if(!con) {
			throw new CustomerException("Wallet Id is different from existing customer wallet Id!");
		}
		

		
		
		
		Optional<Beneficiary> benefi = beneficiaryRepo.findById(beneficiary.getBeneficiaryMobileNumber());
		
		if(!benefi.isPresent()) {
			Optional<Wallet> optional  = walletDao.findById(beneficiary.getWallet().getWalletId());
			beneficiary.getWallet().setBalance(optional.get().getBalance());
			return beneficiaryRepo.save(beneficiary);
		}
		
		throw new BeneficiaryException("Benififciary is already Exist!");
	}

	
	/*=============================================== Delete Benificiary =================================================*/
	
	@Override
	public Beneficiary deleteBeneficiary(String key, BeneficiaryDTO beneficiaryDTO)
			throws BeneficiaryException, CustomerException {
		
		CustomerUserSession customerUserSession = currRepo.findByUuid(key);
		
		if(customerUserSession==null) {
			throw new CustomerException("Customer is not Logged in!");
		}
		
//		Wallet wallet = walletRepo.showCustomerWalletDetails(customerUserSession.getUserId());
		
//		Beneficiary ben = beneficiaryRepo.findByMobileWallet(wallet.getWalletId(), beneficiaryDTO.getBeneficiaryMobileNumber());
		Beneficiary ben= beneficiaryRepo.findByBeneficiaryMobileNumber(beneficiaryDTO.getBeneficiaryMobileNumber());
		
		if(ben==null) {
			throw new BeneficiaryException("Benificiary is not found!");
		}
		
		beneficiaryRepo.delete(ben);
		
		return ben;
	}

	/*=============================================== View Benificiary =================================================*/
	
	@Override
	public Beneficiary viewBeneficiary(String beneficiaryName, String key)
			throws BeneficiaryException, CustomerException {
		
		CustomerUserSession customerUserSession = currRepo.findByUuid(key);
		
		if(customerUserSession==null) {
			throw new CustomerException("Customer is not Logged in!");
		}
		
		Wallet wallet = walletRepo.showCustomerWalletDetails(customerUserSession.getUserId());
		
		Beneficiary ben = beneficiaryRepo.findByNameWallet(wallet.getWalletId(), beneficiaryName);
		
		if(ben==null) {
			throw new BeneficiaryException("Benificiary is not found!");
		}
		
		return ben;
		
	}

	/*=============================================== View All Benificiary =================================================*/
	
	@Override
	public List<Beneficiary> viewAllBeneficiary(String key) throws BeneficiaryException, CustomerException {
		
		CustomerUserSession customerUserSession = currRepo.findByUuid(key);
		
		if(customerUserSession==null) {
			throw new CustomerException("Customer is not Logged in!");
		}
		
		Wallet wallet = walletRepo.showCustomerWalletDetails(customerUserSession.getUserId());
		
		List<Beneficiary> listOfBen = beneficiaryRepo.findByWallet(wallet.getWalletId());
		
		if(listOfBen.isEmpty()) {
			throw new BeneficiaryException("Benificiary is not found!");
		}
		
		return listOfBen;
	}

	

}
