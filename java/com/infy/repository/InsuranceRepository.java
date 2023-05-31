package com.infy.repository;

import java.util.List;

import com.infy.exception.InsuranceException;
import com.infy.model.PolicyDTO;

public interface InsuranceRepository {

	public String buyPolicy(PolicyDTO policy) throws InsuranceException;
	public List<PolicyDTO> getAllPolicyDetails() throws InsuranceException;
	
	
}
