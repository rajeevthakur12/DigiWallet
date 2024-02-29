package com.DigiWallet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.DigiWallet.exception.BeneficiaryException;
import com.DigiWallet.exception.CustomerException;
import com.DigiWallet.exception.WalletException;
import com.DigiWallet.model.Beneficiary;
import com.DigiWallet.model.BeneficiaryDTO;
import com.DigiWallet.service.BeneficiaryService;

import jakarta.validation.Valid;

@RestController
public class BeneficiaryController {

	@Autowired
	private BeneficiaryService beneficiaryService;
	
	@PostMapping("/addBeneficiary/{key}")
	public ResponseEntity<Beneficiary> addBeneficiaryMapping(@RequestBody Beneficiary beneficiary,@PathVariable String key)throws BeneficiaryException, CustomerException, WalletException{
		
		return new ResponseEntity<Beneficiary>(beneficiaryService.addBeneficiary(beneficiary, key), HttpStatus.CREATED);
		
	}
	
	
	@DeleteMapping("/deleteBeneficiary/{key}")
	public ResponseEntity<Beneficiary> deleteBeneficiaryMapping(@Valid @RequestBody BeneficiaryDTO beneficiaryDTO,@PathVariable String key)throws BeneficiaryException, CustomerException, WalletException{
		
		return new ResponseEntity<Beneficiary>(beneficiaryService.deleteBeneficiary(key, beneficiaryDTO), HttpStatus.OK);
		
	}
	
	
	@GetMapping("/viewBeneficiary/{beneficiaryName}/{key}")
	public ResponseEntity<Beneficiary> viewBeneficiaryMapping(@PathVariable String beneficiaryName,@PathVariable String key)throws BeneficiaryException, CustomerException{
		
		return new ResponseEntity<Beneficiary>(beneficiaryService.viewBeneficiary(beneficiaryName, key), HttpStatus.OK);
	}
	
	
	@GetMapping("/viewAllBeneficiary/{key}")
	public ResponseEntity<List<Beneficiary>> viewAllBeneficiaryMapping(@PathVariable String key)throws BeneficiaryException, CustomerException{
		
		return new ResponseEntity<List<Beneficiary>>(beneficiaryService.viewAllBeneficiary(key), HttpStatus.OK);
	}
}
