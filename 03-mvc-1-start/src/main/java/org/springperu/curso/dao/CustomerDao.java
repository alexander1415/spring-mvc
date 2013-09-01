package org.springperu.curso.dao;

import java.util.List;

import org.springperu.curso.model.Customer;

public interface CustomerDao {
	public void saveCustomer(Customer customer);

	public void updateCustomer(Customer customer);

	public void deleteCustomer(Customer customer);

	public Customer getCustomer(Customer customer);

	public List<Customer> getCustomers();
}




