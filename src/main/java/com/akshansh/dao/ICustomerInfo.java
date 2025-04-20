package com.akshansh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akshansh.model.CustomerInfo;

public interface ICustomerInfo extends JpaRepository<CustomerInfo, Integer> {

}
