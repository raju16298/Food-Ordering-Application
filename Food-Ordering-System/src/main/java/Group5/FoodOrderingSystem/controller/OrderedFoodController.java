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

import Group5.FoodOrderingSystem.entity.Food;
import Group5.FoodOrderingSystem.entity.Order;
import Group5.FoodOrderingSystem.entity.OrderedFood;
import Group5.FoodOrderingSystem.exception.FoodNotFoundException;
import Group5.FoodOrderingSystem.exception.OrderNotFoundException;
import Group5.FoodOrderingSystem.exception.OrderedFoodNotFoundException;
import Group5.FoodOrderingSystem.impl.FoodServiceImpl;
import Group5.FoodOrderingSystem.impl.OrderServiceImpl;
import Group5.FoodOrderingSystem.impl.OrderedFoodServiceImpl;



@RestController
@RequestMapping("/Foodie")
public class OrderedFoodController {
	
	@Autowired
	private OrderedFoodServiceImpl ofsimpl;
	
	@Autowired
	private FoodServiceImpl fsimpl;
	
	@Autowired
	private OrderServiceImpl osimpl;
	
	@GetMapping("/orders history")
	public List<OrderedFood> getAll(){
		return ofsimpl.getAllOrderedFood();
	}
	
	@PostMapping("/orders history/new orders")
	public String addOrderedFood(@RequestBody OrderedFood orderedFood) {
		return ofsimpl.addOrderedFood(orderedFood);
	}
	
	@DeleteMapping("/cart/delete/{id}")
	public String deleteOrderProduct(@PathVariable long id) {
		return ofsimpl.deleteOrderedFood(id);
	}
	
	@PatchMapping("/orders history/editCart/{id}")
	public String editOrderedFood(@PathVariable long id, @RequestBody OrderedFood orderedFood) {
			OrderedFood of = ofsimpl.getOrderedFood(id);
			if(of == null) {
				try {
					throw new OrderedFoodNotFoundException("Not found!");
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			of.setQuantity(orderedFood.getQuantity());
		return ofsimpl.editOrderedFood(of);
	}
	
	@GetMapping("/orders history/{id}")
	public OrderedFood getOrderedFood(@PathVariable long id) {
		return ofsimpl.getOrderedFood(id);
	}
	
	@GetMapping("/order/{oid}/orders history")
	public List<OrderedFood> getByStore(@PathVariable long oid){
		Order order = osimpl.getOrder(oid);
		if(order == null) {
			try {
				throw new OrderNotFoundException("Order not found!");
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return ofsimpl.findByOrder(order);
	}
	

	
	/*@PostMapping("/orders history/add in history/{oid}/{id}/{pid}")
	public String addToHistory(@PathVariable long id, @PathVariable long oid,@PathVariable long pid ,@RequestBody OrderedFood orderedFood) {
		Order order = osimpl.getOrder(oid);
		if(order == null) {
			try {
				throw new OrderNotFoundException("Order not found!");
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		orderedFood.setOrder(order);
		
		orderedFood.setId(id);
		
		Food food = fsimpl.getFood(pid);
		
		if(food == null) {
			try {
				throw new FoodNotFoundException("Food not found!");
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		orderedFood.setFood(food);
		
		return ofsimpl.addOrderedFood(orderedFood);
	}*/
	
	
	
	
}


