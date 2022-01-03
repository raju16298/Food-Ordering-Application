package Group5.FoodOrderingSystem.repository;

import org.springframework.data.repository.CrudRepository;

import Group5.FoodOrderingSystem.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	Customer findByEmail(String email);
}
