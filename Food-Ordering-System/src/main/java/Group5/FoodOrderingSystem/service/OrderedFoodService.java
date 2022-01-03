package Group5.FoodOrderingSystem.service;

import java.util.List;

import Group5.FoodOrderingSystem.entity.Order;
import Group5.FoodOrderingSystem.entity.OrderedFood;



public interface OrderedFoodService {
	List<OrderedFood> getAllOrderedFood();
	String addOrderedFood(OrderedFood orderedFood);
	String deleteOrderedFood(long id);
	String editOrderedFood(OrderedFood orderedFood);
	OrderedFood getOrderedFood(long id);
	List<OrderedFood> findByOrder(Order order);
	double calculateAmount(double price, int quantity);
	boolean isFoodAvailable(long id,int quantity);
}
