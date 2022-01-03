package Group5.FoodOrderingSystem.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import Group5.FoodOrderingSystem.entity.Customer;
import Group5.FoodOrderingSystem.exception.CustomerNotFoundException;
import Group5.FoodOrderingSystem.repository.CustomerRepository;
import Group5.FoodOrderingSystem.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> customer = (List<Customer>)customerRepository.findAll();
		return customer;
	}

	@Override
	public String addCustomer(Customer customer) {
		Customer c = customerRepository.save(customer);
		if(c != null) {
			return "Customer added successfully";
		}else {
			return "Customer not added!";
		}
		
	}

	@Override
	public String deleteCustomer(long id) {
		customerRepository.deleteById(id);
		return "Customer deleted!";
	}

	@Override
	public String editCustomer(Customer customer) {
		Customer c = customerRepository.save(customer);
		if(c != null) {
			return "Client updated successfully";
		}else {
			return "Client  not updated!";
		}
		
	}

	@Override
	public Customer getCustomer(long id) {
		Customer customer = customerRepository.findById(id).get();
		if(customer == null) {
			try {
				throw new CustomerNotFoundException("Customer not found!");
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return customer;
	}

	@Override
	public String login(String email, String password) {
		Customer customer = customerRepository.findByEmail(email);
		if(customer == null) {
			return "Customer not found!";
		}else if(password.equals(customer.getPassword())) {
			return "Login Successfully";
		}else {
			return "Invalid Password";
		}
		
	}

	@Override
	public Customer getCustomer(String email) {
		Customer customer = customerRepository.findByEmail(email);
		if(customer == null) {
			try {
				throw new CustomerNotFoundException("Customer not found!");
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return customer;
	}

}
