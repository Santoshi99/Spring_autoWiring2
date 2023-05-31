package com.infy.model;

public class PolicyReportDTO {
	
	private String policyNumber;
	private String policyHolderName;
	private Double policyHolderAge;
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
	public void setPolicyHolderName(String policyHolderName) {
		this.policyHolderName = policyHolderName;
	}
	public Double getPolicyHolderAge() {
		return policyHolderAge;
	}
	public void setPolicyHolderAge(Double policyHolderAge) {
		this.policyHolderAge = policyHolderAge;
	}
	public Integer getTenureInMonths() {
		return tenureInMonths;
	}
	public void setTenureInMonths(Integer tenureInMonths) {
		this.tenureInMonths = tenureInMonths;
	}
	@Override
	public String toString() {
		return "PolicyReportDTO [policyNumber=" + policyNumber + ", policyHolderName=" + policyHolderName
				+ ", policyHolderAge=" + policyHolderAge + ", tenureInMonths=" + tenureInMonths + "]";
	}
	
	
	
}
