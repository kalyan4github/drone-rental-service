package com.techdenovo.app.drs.dao;

import java.util.List;

import com.techdenovo.app.drs.model.Customer;

public interface CustomerDAO {
	public List<Customer> findAll();

}
