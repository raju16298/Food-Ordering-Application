package Group5.FoodOrderingSystem.repository;

import org.springframework.data.repository.CrudRepository;


import Group5.FoodOrderingSystem.entity.Restaurant;


public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
	Restaurant findByPhone(String name);
}
