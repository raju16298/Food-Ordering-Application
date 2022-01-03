package Group5.FoodOrderingSystem.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import Group5.FoodOrderingSystem.entity.Order;
import Group5.FoodOrderingSystem.entity.OrderedFood;
import Group5.FoodOrderingSystem.repository.CustomerRepository;
import Group5.FoodOrderingSystem.repository.FoodRepository;
import Group5.FoodOrderingSystem.repository.OrderRepository;
import Group5.FoodOrderingSystem.repository.OrderedFoodRepository;
import Group5.FoodOrderingSystem.repository.RestaurantRepository;
import Group5.FoodOrderingSystem.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orepo;
	
	@Autowired
	private OrderedFoodRepository ofrepo;
	
	@Autowired
	private FoodRepository frepo;
	
	@Autowired
	private CustomerRepository crepo;
	
	@Autowired
	private RestaurantRepository rrepo;
	

	@Override
	public List<Order> getAllOrder() {
		return (List<Order>) orepo.findAll();
	}

	@Override
	public String addOrder(Order order) {
		double totalAmount = calculateTotalAmount(order);
		order.setTotal(totalAmount);
		Order o = orepo.save(order);
		if(o != null) {
			return "Order added";
		}else {
		return "Order not added!";
		}
	}

	@Override
	public String deleteOrder(long id) {
		orepo.deleteById(id);
		return "Order deleted!";
	}

	@Override
	public String editOrder(Order order) {
		double totalAmount = calculateTotalAmount(order);
		order.setTotal(totalAmount);
		Order o = orepo.save(order);
		if(o != null) {
			return "Order updated";
		}else {
		return "Order not updated!";
		}
	}

	@Override
	public Order getOrder(long id) {
		Order order = orepo.findById(id).get();
		if(order == null) {
			try {
				throw new Group5.FoodOrderingSystem.exception.OrderNotFoundException("Order not found!");
			}catch(Exception e ) {
				System.out.println(e.getMessage());
			}
		}
		return order;
	}

	@Override
	public double calculateTotalAmount(Order order) {
		List<OrderedFood> oflist = ofrepo.findByOrder(order);
		double totalAmount = 0;
		for(OrderedFood of: oflist) {
			totalAmount += of.getAmount();
		}
		return totalAmount;
	}

	
}
