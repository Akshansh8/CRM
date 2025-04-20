package com.akshansh.service;

import java.util.List;

import com.akshansh.model.CustomerInfo;

public interface ICustomerService {
	
	List<CustomerInfo> getAllCustomer();
	void registerCustomer(CustomerInfo info);
	CustomerInfo getCustomer(Integer id);
	void deleteCustomer(Integer id);

}
