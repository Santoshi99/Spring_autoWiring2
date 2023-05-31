package com.infy.service;

import java.time.LocalDate;
import java.util.List;

import com.infy.exception.InsuranceException;
import com.infy.model.PolicyDTO;
import com.infy.model.PolicyReportDTO;

public interface InsuranceService {
	
	public String buyPolicy(PolicyDTO policy) throws InsuranceException;
	public Long calculateAge(LocalDate dateOfBirth) throws InsuranceException;
	public List<PolicyReportDTO> getReport(String insuranceType) throws InsuranceException;
	

}
