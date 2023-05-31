package com.infy.validator;

import java.time.LocalDate;

import com.infy.exception.InsuranceException;
import com.infy.model.PolicyDTO;

public class Validator {


	public static void validate(PolicyDTO policy) throws InsuranceException{
		
		if(!validatePolicyNumber(policy.getPolicyNumber(),policy.getPolicyType())) {
			throw new InsuranceException("Validator.INVALID_POLICY_NUMBER");
		}
		else if(!validatePolicyType(policy.getPolicyType())) {
			throw new InsuranceException("Validator.INVALID_POLICY_TYPE");
		}
		else if(!validatePremium(policy.getPremium())) {
			throw new InsuranceException("Validator.INVALID_PREMIUM");
		}
		else if(!validateTenure(policy.getTenureInMonths())) {
			throw new InsuranceException("Validator.INVALID_TENURE");
		}
		else if(!validateDateOfBirth(policy.getDateOfBirth())) {
			throw new InsuranceException("Validator.INVALID_DOB");
		}
		else if(!validatePolicyHolderName(policy.getPolicyHolderName())) {
			throw new InsuranceException("Validator.INVALID_HOLDER_NAME");
		}
		else if(!validatePolicyName(policy.getPolicyName())) {
			throw new InsuranceException("Validator.INVALID_POLICY_NAME");
		}
	}

	
	public static Boolean validatePolicyName(String policyName){

		String regex = "[A-Za-z]+";
		if(policyName.matches(regex)) return true;
		return false;
    }
	
	public static Boolean validatePolicyType(String policyType){
        
		if(policyType.equalsIgnoreCase("Term Life Insurance")||
			policyType.equalsIgnoreCase("Whole Life Policy")||
			policyType.equalsIgnoreCase("Endowment Plans"))
			return true;
		return false;

	}
	
	public static Boolean validatePremium(Double premium){

		if(premium >100)return true;
		return false;

	}
	
	public static Boolean validateTenure(Integer tenureInMonths){

		if(tenureInMonths>24) return true;
		return false;

	}

	
	public static Boolean validateDateOfBirth(LocalDate dateOfBirth){

		if(LocalDate.now().isAfter(dateOfBirth))return true;
		return false;

	}

	
	public static Boolean validatePolicyNumber(String policyNumber,String policyType){

		if(policyType.equalsIgnoreCase("Term Life Insurance")) {
			String regex = "(TL)-(\\d+){6}";
			if(policyNumber.matches(regex)) {
				return true;
			}
		}
		else if(policyType.equalsIgnoreCase("Whole Life Policy")){
			String regex = "(WL)-(\\d+){6}";
			if(policyNumber.matches(regex)) {
				return true;
			}
		}
		else if(policyType.equalsIgnoreCase("EndowMent Plans")){
			String regex = "(EP)-(\\d+){6}";
			if(policyNumber.matches(regex)) {
				return true;
			}
		}
		return false;

	}

	
	public static Boolean validatePolicyHolderName(String policyHolderName){

		String regex = "\\w{3}\\w+";
		if(policyHolderName.matches(regex))return true;
		return false;

	}
}
