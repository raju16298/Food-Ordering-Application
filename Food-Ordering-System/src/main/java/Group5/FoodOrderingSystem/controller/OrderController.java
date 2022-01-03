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

import Group5.FoodOrderingSystem.entity.Order;
import Group5.FoodOrderingSystem.impl.OrderServiceImpl;



@RestController
@RequestMapping("/Foodie")
public class OrderController {

	@Autowired
	private OrderServiceImpl impl;
	
	@GetMapping("/orders")
	public List<Order> getAll(){
		return impl.getAllOrder();
	}
	
	@PostMapping("/order/addOrder")
	public String addOrder(@RequestBody Order order) {
		return impl.addOrder(order);
	}
	
	@DeleteMapping("/order/deleteOrder/{id}")
	public String deleteOrder(@PathVariable long id) {
		return impl.deleteOrder(id);
	}
	
	@PatchMapping("/order/editOrder")
	public String editOrder(@RequestBody Order order) {
		return impl.editOrder(order);
	}

	@GetMapping("/order/{id}")
	public Order getOrder(@PathVariable long id) {
		return impl.getOrder(id);
	}
	
	
	
	
	

}
