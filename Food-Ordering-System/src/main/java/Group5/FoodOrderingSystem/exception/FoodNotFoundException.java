package Group5.FoodOrderingSystem.exception;

public class FoodNotFoundException extends Exception {
	public FoodNotFoundException() {
		super();
	}
	public FoodNotFoundException(String error) {
		super(error);
	}

}
