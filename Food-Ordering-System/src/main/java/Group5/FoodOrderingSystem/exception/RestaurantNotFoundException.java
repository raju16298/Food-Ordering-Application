package Group5.FoodOrderingSystem.exception;

public class RestaurantNotFoundException extends Exception {

	public RestaurantNotFoundException() {
		super();
	}
	
	public RestaurantNotFoundException(String error) {
		super(error);
	}
}
