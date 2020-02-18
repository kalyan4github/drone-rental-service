package com.techdenovo.app.drs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.techdenovo.app.drs.model.Customer;
import com.techdenovo.app.drs.utility.DBUtility;

public class CustomerDAOImpl implements CustomerDAO {

	DBUtility dbutility=null;
	Connection con=null;
	
	@Override
	public List<Customer> findAll() {
		dbutility = new DBUtility();
		con=dbutility.createConnection();
		ArrayList<Customer> customers=null;
		if(con!=null) {
			customers = new  ArrayList<>();
			try {
				PreparedStatement ps = con.prepareStatement("SELECT * FROM CUSTOMER");
				ResultSet rs =ps.executeQuery();
				while (rs.next()) {
					Customer customer = new Customer(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
					customers.add(customer);
				}
				
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		return customers;
	}

}
