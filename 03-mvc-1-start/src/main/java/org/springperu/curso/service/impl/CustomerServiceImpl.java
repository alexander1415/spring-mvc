package org.springperu.curso.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springperu.curso.dao.CustomerDao;
import org.springperu.curso.dao.jdbc.CustomerDaoJdbc;
import org.springperu.curso.model.Customer;
import org.springperu.curso.service.CustomerService;

@Service
public class CustomerServiceImpl {
	@Autowired
	CustomerDaoJdbc customerDao = new CustomerDaoJdbc();
	
	public void saveCustomer(Customer customer) {
		customerDao.saveCustomer(customer);
	}
	
	public Customer getCustomer(Customer customer) {
		return customerDao.getCustomer(customer);
	}

	public List<Customer> getCustomers() {
		return customerDao.getCustomers();
	}

	public void deleteCustomer(Customer customer) {
		customerDao.deleteCustomer(customer);
		
	}

	public void updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);
	}
	
}

