package Group5.FoodOrderingSystem.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import Group5.FoodOrderingSystem.entity.Order;
import Group5.FoodOrderingSystem.entity.OrderedFood;

public interface OrderedFoodRepository extends CrudRepository<OrderedFood, Long> {

	List<OrderedFood> findByOrder(Order order);
}
