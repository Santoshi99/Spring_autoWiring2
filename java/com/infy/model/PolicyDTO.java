package com.infy.model;

import java.time.LocalDate;

public class PolicyDTO {

	private String policyNumber;
	private String policyHolderName;
	private LocalDate dateOfBirth;
	private String policyName;
	private String policyType;
	private Double premium;
	private Integer tenureInMonths;

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getPolicyHolderName() {
		return policyHolderName;
	}

	public void setPolicyHolderName(String policyHolderNumber) {
		this.policyHolderName = policyHolderNumber;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public Double getPremium() {
		return premium;
	}

	public void setPremium(Double premium) {
		this.premium = premium;
	}

	public Integer getTenureInMonths() {
		return tenureInMonths;
	}

	public void setTenureInMonths(Integer tenureInMonth) {
		this.tenureInMonths = tenureInMonth;
	}

	@Override
	public String toString() {
		return "PolicyDTO [policyNumber=" + policyNumber + ", policyHolderName=" + policyHolderName + ", dateOfBirth="
				+ dateOfBirth + ", policyName=" + policyName + ", policyType=" + policyType + ", premium=" + premium
				+ ", tenureInMonths=" + tenureInMonths + "]";
	}
	
	
	

}
