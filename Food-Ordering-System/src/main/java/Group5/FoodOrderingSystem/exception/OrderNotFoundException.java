package Group5.FoodOrderingSystem.exception;

public class OrderNotFoundException extends Exception {
	
	public OrderNotFoundException() {
		super();
	}
	public OrderNotFoundException(String error) {
		super(error);
	}
}
