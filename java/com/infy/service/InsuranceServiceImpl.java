package com.infy.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;
import java.util.LinkedList;
import com.infy.exception.InsuranceException;
import com.infy.model.PolicyDTO;
import com.infy.model.PolicyReportDTO;
import com.infy.repository.InsuranceRepositoryImpl;
import com.infy.validator.Validator;

import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class InsuranceServiceImpl implements InsuranceService{

    @Autowired
	InsuranceRepositoryImpl insuranceRepositoryImpl;
	
	public String buyPolicy(PolicyDTO policy) throws InsuranceException {
		String reppolicy = null;
		try {
		Validator.validate(policy);
		reppolicy = insuranceRepositoryImpl.buyPolicy(policy);		
		}
		catch(InsuranceException e) {
			LogFactory.getLog(this.getClass()).error(e.getMessage(),e);
			throw e;
		}
		return reppolicy;
	}

	public Long calculateAge(LocalDate dateOfBirth) throws InsuranceException {
		Integer dob = null;
		if(dateOfBirth!=null) {
		
		  dob = Period.between(LocalDate.now(),dateOfBirth).getYears();
		
		}
		return Long.valueOf(dob);
	}

	public List<PolicyReportDTO> getReport(String policyType) throws InsuranceException {
		
		List<PolicyDTO> policydto = insuranceRepositoryImpl.getAllPolicyDetails();
		
		List<PolicyDTO> list = policydto.stream().filter(p -> p.getPolicyType().equals(policyType)).collect(Collectors.toList());
		List<PolicyReportDTO> report = new LinkedList<>();
		for(PolicyDTO policy : list) {
			PolicyReportDTO plist = new PolicyReportDTO();
			plist.setPolicyNumber(policy.getPolicyNumber());
			plist.setPolicyHolderName(policy.getPolicyHolderName());
			plist.setTenureInMonths(policy.getTenureInMonths());
			Double age = Double.valueOf(calculateAge(policy.getDateOfBirth()));
			plist.setPolicyHolderAge(age);
			report.add(plist);
		}
		return report;
	}

		
	
	
}
