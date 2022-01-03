package Group5.FoodOrderingSystem.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import Group5.FoodOrderingSystem.entity.Food;
import Group5.FoodOrderingSystem.exception.FoodNotFoundException;
import Group5.FoodOrderingSystem.repository.FoodRepository;
import Group5.FoodOrderingSystem.service.FoodService;

@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	private FoodRepository frepo;
	
	@Override
	public List<Food> getAllFood() {
		return (List<Food>) frepo.findAll();
	}

	@Override
	public String addFood(Food food) {
		Food f = frepo.save(food);
		if(f != null) {
			return "Food added";
		}else {
			return "Food not added!";	
		}
		
	}

	@Override
	public String deleteFood(long id) {
		frepo.deleteById(id);
		return "Food deleted!";
	}

	@Override
	public String editFood(Food food) {
		Food f = frepo.save(food);
		if(f != null) {
			return "Food updated";
		}else {
			return "Food not updated!";	
		}
	}

	@Override
	public Food getFood(long id) {
		Food food = frepo.findById(id).get();
		if(food == null) {
			try {
				throw new FoodNotFoundException("Product not found!");
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return food;
	}

}
