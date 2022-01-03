package Group5.FoodOrderingSystem.service;

import java.util.List;

import Group5.FoodOrderingSystem.entity.Restaurant;

public interface RestaurantService {

	List<Restaurant> getAllRestaurant();
	String addRestaurant(Restaurant restaurant);
	String deleteRestaurant(long id);
	String editRestaurant(Restaurant restaurant);
	Restaurant getRestaurant(long id);
	Restaurant getRestaurant(String email);
	String login(String email, String password);
}
