package Group5.FoodOrderingSystem.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Group5.FoodOrderingSystem.entity.Restaurant;
import Group5.FoodOrderingSystem.exception.RestaurantNotFoundException;
import Group5.FoodOrderingSystem.repository.RestaurantRepository;
import Group5.FoodOrderingSystem.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {
	@Autowired
	private RestaurantRepository rrepo;
	
	@Override
	public List<Restaurant> getAllRestaurant() {
		return (List<Restaurant>) rrepo.findAll();
	}

	@Override
	public String addRestaurant(Restaurant restaurant) {
		Restaurant r = rrepo.save(restaurant);
		if(r != null) {
			return "Restaurant added";
		}else {
			return "Restaurant not added!";
		}
	}

	@Override
	public String deleteRestaurant(long id) {
		rrepo.deleteById(id);
		return "Restaurant deleted!";
	}

	@Override
	public String editRestaurant(Restaurant restaurant) {
		Restaurant r = rrepo.save(restaurant);
		if(r != null) {
			return "Restaurant updated";
		}else {
			return "Restaurant not updated!";
		}
	}

	@Override
	public Restaurant getRestaurant(long id) {
		Restaurant restaurant = rrepo.findById(id).get();
		if(restaurant == null) {
			try {
				throw new RestaurantNotFoundException("Restaurant not found!");
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		return restaurant;
	}

	@Override
	public Restaurant getRestaurant(String email) {
		Restaurant restaurant = rrepo.findByPhone(email);
		if(restaurant == null) {
			try {
				throw new RestaurantNotFoundException("Restaurant not found!");
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		return restaurant;
	}

	@Override
	public String login(String email, String password) {
		Restaurant restaurant = rrepo.findByPhone(email);
		if(restaurant == null) {
			return "Restaurant not found!";
		}else if(password.equals(restaurant.getPassword())) {
			return "Login Successfully";
		}else {
			return "Invalid password!";
		}
	}

}
