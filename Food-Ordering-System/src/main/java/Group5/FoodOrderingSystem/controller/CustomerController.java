package Group5.FoodOrderingSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Group5.FoodOrderingSystem.entity.Customer;
import Group5.FoodOrderingSystem.impl.CustomerServiceImpl;

@RestController
@RequestMapping("/Foodie")
public class CustomerController {
	
	@Autowired
	private CustomerServiceImpl impl;

	@GetMapping("/getAll")
	public List<Customer> getAllCustomer(){
		return impl.getAllCustomer();
	}
	
	@PostMapping("/addcustomer")
	public String addCustomer(@RequestBody Customer customer) {
		return impl.addCustomer(customer);
	}
	
	@DeleteMapping("/deleteCustomer")
	public String deleteCustomer(@PathVariable("id") long id) {
		return impl.deleteCustomer(id);
	}
	
	@PatchMapping("/editCustomer")
	public String editCustomer(@RequestBody Customer customer) {
		return impl.editCustomer(customer);
	}
	
	@GetMapping("/customer/{id}")
	public Customer getCustomer(@PathVariable long id) {
		return impl.getCustomer(id);
	}
	
	@GetMapping("/customer/email/{email}")
	public Customer getCustomerByEmail(@PathVariable String email) {
		return impl.getCustomer(email);
	}
	
	@PostMapping("customer/login")
	public String login(@RequestBody Customer customer) {
		return impl.login(customer.getEmail(), customer.getPassword());
	}
	
	

}
