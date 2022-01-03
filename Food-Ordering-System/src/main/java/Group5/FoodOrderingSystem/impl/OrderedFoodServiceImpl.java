package Group5.FoodOrderingSystem.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import Group5.FoodOrderingSystem.entity.Food;
import Group5.FoodOrderingSystem.entity.Order;
import Group5.FoodOrderingSystem.entity.OrderedFood;
import Group5.FoodOrderingSystem.exception.FoodNotFoundException;
import Group5.FoodOrderingSystem.exception.OrderedFoodNotFoundException;
import Group5.FoodOrderingSystem.repository.FoodRepository;
import Group5.FoodOrderingSystem.repository.OrderedFoodRepository;
import Group5.FoodOrderingSystem.service.OrderedFoodService;

public class OrderedFoodServiceImpl implements OrderedFoodService {
	
	@Autowired
	private OrderedFoodRepository repo;
	
	@Autowired
	private OrderServiceImpl impl;
	
	@Autowired
	private FoodRepository prepo;

	@Override
	public List<OrderedFood> getAllOrderedFood() {
		return (List<OrderedFood>) repo.findAll();
	}

	@Override
	public String addOrderedFood(OrderedFood orderedFood) {
		// TODO Auto-generated method stub
		double price = orderedFood.getFood().getPrice();
		int quantity = orderedFood.getQuantity();
		double amount = calculateAmount(price,quantity);
		orderedFood.setAmount(amount);
		
		if(isFoodAvailable(orderedFood.getFood().getId(), orderedFood.getQuantity())) {
			OrderedFood of = repo.save(orderedFood);
			if(of != null) {
				impl.editOrder(of.getOrder());
				return "Order Placed";
			}else {
				return "Order Not Placed";
			}	
		}else {
			return "Out of stock!";
		}
		
	}

	@Override
	public String deleteOrderedFood(long id) {
		OrderedFood of = repo.findById(id).get();
		repo.deleteById(id);
		impl.editOrder(of.getOrder());
		return "Order Canceled By Retaurant Side";
	}

	@Override
	public String editOrderedFood(OrderedFood orderedFood) {
		// TODO Auto-generated method stub
		double price = orderedFood.getFood().getPrice();
		int quantity = orderedFood.getQuantity();
		double amount = calculateAmount(price,quantity);
		orderedFood.setAmount(amount);
		
		if(isFoodAvailable(orderedFood.getFood().getId(), orderedFood.getQuantity())) {
			OrderedFood of = repo.save(orderedFood);
			if(of != null) {
				impl.editOrder(of.getOrder());
				return "Updated";
			}else {
				return "Not Updated";
			}	
		}else {
			return "Out of stock!";
		}
	
	}

	@Override
	public OrderedFood getOrderedFood(long id) {
		OrderedFood of = repo.findById(id).get();
		if(of == null) {
			try {
				throw new OrderedFoodNotFoundException("Not found!");
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return of;
	}

	@Override
	public double calculateAmount(double price, int quantity) {
		double amount = price * quantity;
		return amount;
	}

	@Override
	public List<OrderedFood> findByOrder(Order order) {
		return repo.findByOrder(order);
	}

	@Override
	public boolean isFoodAvailable(long id, int quantity) {
		boolean flag = false;
		Food food = prepo.findById(id).get();
		if(food == null) {
			try {
				throw new FoodNotFoundException("Food not found!");
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		if(quantity <= food.getQuantity()) {
			flag = true;
		}
		return flag;
		
	}
}
