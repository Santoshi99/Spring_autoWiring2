package com.infy.ui;

import java.time.LocalDate;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import com.infy.configuration.SpringConfig;
import com.infy.exception.InsuranceException;
import com.infy.model.PolicyDTO;
import com.infy.model.PolicyReportDTO;
import com.infy.service.InsuranceServiceImpl;

public class UserInterface {
	
	public static final Log LOGGER = LogFactory.getLog(UserInterface.class); 


	public static void main(String[] args) throws Exception{
			buyPolicy();
			//generateReport();
	}

	public static void buyPolicy() throws Exception{
		Environment environment=null;
		ApplicationContext applicationContext =null;
		try{
			applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
			environment=applicationContext.getEnvironment();
			InsuranceServiceImpl insuranceServiceImpl=applicationContext.getBean(InsuranceServiceImpl.class);
			PolicyDTO policy=new PolicyDTO();
			policy.setPolicyNumber("WL-553912");
			policy.setPolicyHolderName("James");
			policy.setDateOfBirth(LocalDate.of(1992, 01, 10));
			policy.setPolicyName("Retirement");
			policy.setPolicyType("Whole Life Policy");
			policy.setPremium(3500.0d);
			policy.setTenureInMonths(180);
			
			String str1=insuranceServiceImpl.buyPolicy(policy);
			
			LOGGER.info(environment.getProperty("UserInterface.SUCCESS")+""+str1);
		}catch(InsuranceException exception){
			LOGGER.error(environment.getProperty(exception.getMessage()));
		}
	}

	public static void generateReport() throws Exception{
		Environment environment=null;
		ApplicationContext applicationContext =null;
		try{				
			applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
			environment=applicationContext.getEnvironment();
			InsuranceServiceImpl insuranceServiceImpl=applicationContext.getBean(InsuranceServiceImpl.class);
			List<PolicyReportDTO> list1=insuranceServiceImpl.getReport("Term Life Insurance");
			//List<PolicyReportDTO> list1=insuranceServiceImpl.getReport("CEOl-88");
			if(list1!=null){
				for(PolicyReportDTO p:list1){
					LOGGER.info(p);
				}
			}
	}catch(InsuranceException exception){
		LOGGER.error(environment.getProperty(exception.getMessage()));
	}
		
	}
}

