package com.akshansh.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akshansh.dao.ICustomerInfo;
import com.akshansh.model.CustomerInfo;
import com.akshansh.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerInfo dao;
	
	public List<CustomerInfo> getAllCustomer(){
		return dao.findAll();
	}
	
	public void registerCustomer(CustomerInfo info)
	{
		dao.save(info);
	}
	
	public CustomerInfo getCustomer(Integer id)
	{
		Optional<CustomerInfo> optional = dao.findById(id);
		return optional.get();
	}
	
	public void deleteCustomer(Integer id) {
		dao.deleteById(id);
	}
}
