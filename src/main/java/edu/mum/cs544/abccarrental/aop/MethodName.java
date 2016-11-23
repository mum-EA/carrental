package edu.mum.cs544.abccarrental.aop;

import org.springframework.beans.factory.annotation.Value;

public class MethodName {
	
	@Value("${homePage}")
	public String homePage;
	
	@Value("${accessDeniedPage}")
	public String accessDeniedPage;
	
	@Value("${logoutPage}")
	public String logoutPage;
	
	@Value("${showCustomerRegister}")
	public String showCustomerRegister;
	
	@Value("${showUpdatePage}")
	public String showCustomerUpdate;
	
	@Value("${showAllCustomers}")
	public String showAllCustomer;
	
	@Value("${getCustomerInfo}")
	public String getCustomerInfo;
	
	@Value("${enableDisableCustomer}")
	public String enableDisalbeCustomer;
	
	@Value("${processAdd}")
	public String processAdd;
	
	public String getHomePage() {
		return homePage;
	}
	public String getAccessDeniedPage() {
		return accessDeniedPage;
	}
	public String getLogoutPage() {
		return logoutPage;
	}
	public String getShowCustomerRegister() {
		return showCustomerRegister;
	}
	
	public String getShowAllCustomer() {
		return showAllCustomer;
	}
	public String getGetCustomerInfo() {
		return getCustomerInfo;
	}
	public String getEnableDisalbeCustomer() {
		return enableDisalbeCustomer;
	}
	public String getProcessAdd() {
		return processAdd;
	}
	public String getShowCustomerUpdate() {
		return showCustomerUpdate;
	}
	
	

}
