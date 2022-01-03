package Group5.FoodOrderingSystem.exception;

public class CustomerNotFoundException extends Exception {

	public CustomerNotFoundException() {
		super();
	}
	public CustomerNotFoundException(String error) {
		super(error);
	}

}
