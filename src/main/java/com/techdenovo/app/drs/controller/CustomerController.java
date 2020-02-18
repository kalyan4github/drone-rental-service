package com.techdenovo.app.drs.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techdenovo.app.drs.dao.CustomerDAO;
import com.techdenovo.app.drs.dao.CustomerDAOImpl;
import com.techdenovo.app.drs.model.Customer;

@WebServlet("/")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public CustomerController() {
        super();
       
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		System.out.println(action);
		switch (action) {
		case "/customer-list":
			listCustomers(request,response);
			break;
		case "/customer-new":
			
			break;	
		default:
			break;
		}
		
	}		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	private void listCustomers(HttpServletRequest request, HttpServletResponse response) {
		CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl();
		List<Customer> customers =customerDAOImpl.findAll();
		request.setAttribute("listCustomers", customers);
		System.out.println(customers.size());
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-customers.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
