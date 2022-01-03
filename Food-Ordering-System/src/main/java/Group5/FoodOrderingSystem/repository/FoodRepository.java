package Group5.FoodOrderingSystem.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import Group5.FoodOrderingSystem.entity.Food;
import Group5.FoodOrderingSystem.entity.Restaurant;


public interface FoodRepository extends CrudRepository<Food, Long>{

	List<Food> findByRestaurant(Restaurant restaurant);
	List<Food> findByName(String name);
}
