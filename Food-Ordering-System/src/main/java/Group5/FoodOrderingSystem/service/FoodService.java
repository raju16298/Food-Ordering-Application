package Group5.FoodOrderingSystem.service;

import java.util.List;



import Group5.FoodOrderingSystem.entity.Food;


public interface FoodService {
	List<Food> getAllFood();
	String addFood(Food food);
	String deleteFood(long id);
	String editFood(Food food);
	Food getFood(long id);
	
	
}
