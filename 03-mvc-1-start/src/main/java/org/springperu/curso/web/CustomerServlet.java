package org.springperu.curso.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springperu.curso.model.Customer;
import org.springperu.curso.service.impl.CustomerServiceImpl;

public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerServiceImpl customerService = new CustomerServiceImpl();
	
    public CustomerServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Customer> customerList= customerService.getCustomers();
		request.setAttribute("customers", customerList);
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/customer_main.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
