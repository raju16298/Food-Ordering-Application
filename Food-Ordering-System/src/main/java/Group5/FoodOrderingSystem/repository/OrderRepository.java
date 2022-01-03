package Group5.FoodOrderingSystem.repository;

import org.springframework.data.repository.CrudRepository;

import Group5.FoodOrderingSystem.entity.Order;



public interface OrderRepository extends CrudRepository<Order, Long> {

}
