package org.springperu.curso.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springperu.curso.model.Customer;
import org.springperu.curso.service.CustomerService;
import org.springperu.curso.service.impl.CustomerServiceImpl;
@Controller
@RequestMapping("/customer/")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("load")
	protected ModelAndView load(HttpServletRequest request, HttpServletResponse response) throws Exception{
		List<Customer> customerList = customerService.getCustomers();
		return new ModelAndView("customer_main","customers",customerList);
	}

	/*public void saveCustomer(Customer customer) {
		customerService.saveCustomer(customer);
	}*/
	
}


