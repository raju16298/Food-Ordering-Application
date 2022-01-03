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
import Group5.FoodOrderingSystem.entity.Restaurant;
import Group5.FoodOrderingSystem.exception.RestaurantNotFoundException;
import Group5.FoodOrderingSystem.impl.CustomerServiceImpl;
import Group5.FoodOrderingSystem.impl.FoodServiceImpl;
import Group5.FoodOrderingSystem.impl.RestaurantServiceImpl;



@RestController
@RequestMapping("/Foodie")
public class RestaurantController {

	@Autowired
	private RestaurantServiceImpl impl;
	
	@Autowired
	private FoodServiceImpl foodImpl;
	
	@Autowired 
	private CustomerServiceImpl clientImpl;
	
	@GetMapping("/restaurants")
	public List<Restaurant> getAll(){
		return impl.getAllRestaurant();
	}
	
	@PostMapping("/restaurant/addRestaurant")
	public String addRestaurant(@RequestBody Restaurant restaurant) {
		return impl.addRestaurant(restaurant);
	}
	
	@DeleteMapping("/restaurant/delete/{id}")
	public String deleteRestaurant(@PathVariable long id) {
		return impl.deleteRestaurant(id);
	}
	
	@PatchMapping("/restaurant/editRestaurant")
	public String editRestaurant(@RequestBody Restaurant restaurant) {
		return impl.addRestaurant(restaurant);
	}
	
	@GetMapping("/restaurant/{id}")
	public Restaurant getRestaurant(@PathVariable long id) {
		return impl.getRestaurant(id);
	}
	
	@GetMapping("/restaurant/email/{email}")
	public Restaurant getRestaurant(@PathVariable String email) {
		return impl.getRestaurant(email);
	}
	@PostMapping("/restaurant/login")
	public String login(@RequestBody Restaurant restaurant) {
		return impl.login(restaurant.getPhone(), restaurant.getPassword());
	}
	
	/*
	@PostMapping("/restaurant/{id}/addFood")
	public String addProduct(@PathVariable long id,@RequestBody Food food) {
		Restaurant restaurant = impl.getRestaurant(id);
		if(restaurant != null) {
			food.setRestaurant(restaurant);
			return foodImpl.addFood(food);
		}else {
			return "Food not added!";
		}
		
	}*/
	
	/*@PatchMapping("/restaurant/{id}/editFood")
	public String editFood(@PathVariable long id,@RequestBody Food food) {
		Restaurant restaurant = impl.getRestaurant(id);
		if(restaurant != null) {
			food.setRestaurant(restaurant);
			return foodImpl.editFood(food);
		}else {
			return "Food not updated!";
		}
		
	}*/
	
	/*@DeleteMapping("/restaurant/{id}/deleteFood/{pid}")
	public String deleteFood(@PathVariable long id,@PathVariable long pid) {
		Restaurant restaurant = impl.getRestaurant(id);
		if(restaurant != null) {
			return foodImpl.deleteFood(pid);
		}else {
			return "Food not deleted!";
		}
		
	}*/

	/*@GetMapping("/restaurant/{id}/foods")
	public List<Food> getAllFoods(@PathVariable long id){
		Restaurant restaurant = impl.getRestaurant(id);
		if(restaurant != null) {
			return foodImpl.findByRestaurant(restaurant);
		}else {
			try {
				throw new RestaurantNotFoundException("Restaurant not found!");
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return null;
	}*/
}
