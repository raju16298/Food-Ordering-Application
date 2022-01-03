package Group5.FoodOrderingSystem.service;

import java.util.List;

import Group5.FoodOrderingSystem.entity.Order;



public interface OrderService {
	List<Order> getAllOrder();
	String addOrder(Order order);
	String deleteOrder(long id);
	String editOrder(Order order);
	Order getOrder(long id);
	double calculateTotalAmount(Order order);
}
