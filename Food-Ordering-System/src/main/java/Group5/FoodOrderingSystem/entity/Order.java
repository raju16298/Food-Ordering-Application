package Group5.FoodOrderingSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
public class Order {
	@Id
	@Column(name="oid")
	private long id;
	
	@OneToOne
	@JoinColumn(name="cid")
	private Customer customer;
	private double total;
	
	
	public Order() {
	}


	public Order(long id, Customer customer) {
		super();
		this.id = id;
		this.customer = customer;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	
	@Override
	public String toString() {
		return String.format("%-5s %-5s %-10.2f",id,customer.getId(),total);	
	} 
	
	
}
