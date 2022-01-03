package Group5.FoodOrderingSystem.exception;

public class OrderedFoodNotFoundException extends Exception {
	public OrderedFoodNotFoundException() {
		super();
	}
	public OrderedFoodNotFoundException(String error) {
		super(error);
	}
}
