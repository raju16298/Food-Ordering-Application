package Group5.FoodOrderingSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Food {
	@Id
	@Column(name="fid")
	private long id;
	@Column(name="fname")
	private String name;
	@Column(name="ftype")
	private String type;
	@Column(name="price")
	private double price;
	@Column(name="quantity")
	private int quantity;
	
	@ManyToOne(targetEntity=Restaurant.class)
	@JoinColumn(name="rid")
	private Restaurant restaurant;
	
	public Food() {
		}
	public Food(long id, String name, String type, double price,int quantity, Restaurant restaurant) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
		this.quantity = quantity;
		this.restaurant = restaurant;
	}
	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}
	
	public long getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public Restaurant getRestaurant() {
		return restaurant;
	}



	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}



	@Override
	public String toString() {
		return "Food [id=" + id + ", name=" + name + ", type=" + type + ", price=" + price + "]";
	}

	
	
}
