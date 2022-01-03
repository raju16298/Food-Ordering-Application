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
import Group5.FoodOrderingSystem.impl.FoodServiceImpl;
import Group5.FoodOrderingSystem.impl.RestaurantServiceImpl;



@RestController
@RequestMapping("/Foodie")
public class FoodController {
	
	@Autowired
	private FoodServiceImpl fimpl;
	
	@Autowired
	private RestaurantServiceImpl simpl;
	
	@GetMapping("/foods")
	public List<Food> getAll(){
		return fimpl.getAllFood();
	}
	
	@PostMapping("/food/addFood")
	public String addFood(@RequestBody Food food) {
		return fimpl.addFood(food);
	}
	
	@DeleteMapping("/food/deleteFood/{id}")
	public String deleteFood(@PathVariable long id) {
		return fimpl.deleteFood(id);
	}
	
	@PatchMapping("/food/editFood")
	public String editFood(@RequestBody Food food) {
		return fimpl.editFood(food);
	}
	@GetMapping("/food/{id}")
	public Food getFood(@PathVariable long id) {
		return fimpl.getFood(id);
	}
	
}
