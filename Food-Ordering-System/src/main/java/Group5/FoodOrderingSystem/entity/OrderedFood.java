package Group5.FoodOrderingSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class OrderedFood {
	@Id
	@Column(name="ofid")
	private long id;
	@Column(name="ofquantity")
	private int quantity;
	@Column(name="amount")
	private double amount;
	
	@OneToOne
	@JoinColumn(name="oid")
	private Order order;
	
	@OneToOne
	@JoinColumn(name="fid")
	private Food food;
	
	public OrderedFood() {
		
	}

	public OrderedFood(long id, int quantity, Order order, Food food) {
		this.id = id;
		this.quantity = quantity;
		this.order = order;
		this.food = food;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}
	
	@Override
	public String toString() {
		return String.format("%-5s %-15s %-15.2f %-15s %-15.2f %-15s",id,food.getName(), food.getPrice(), quantity,amount,order.getCustomer().getName());
	}

}
