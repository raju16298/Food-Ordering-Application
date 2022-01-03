package Group5.FoodOrderingSystem.service;

import java.util.List;

import Group5.FoodOrderingSystem.entity.Customer;

public interface CustomerService {
	List<Customer> getAllCustomer();
	String addCustomer(Customer customer);
	String deleteCustomer(long id);
	String editCustomer(Customer customer);
	Customer getCustomer(long id);
	Customer getCustomer(String email);
	String login(String email, String password);
}
