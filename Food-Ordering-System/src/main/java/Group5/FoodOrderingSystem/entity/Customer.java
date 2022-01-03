package Group5.FoodOrderingSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
	@Column(name="cid")
	private long id;
	@Column(name="cname")
	private String name;
	@Column(name="email")
	private String email;
	@Column(name="phone")
	private String phone;
	@Column(name="password")
	private String password;
	@Column(name="address")
	private String address;
	
	public Customer() {
		
	}

	public Customer(long id, String name, String email, String phone, String password, String address) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.address = address;
	
	}

	public Customer(long id, String name, String address, String password) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email +  ", phone=" + phone +", password="
				+ password + ", address=" + address + "]";
	}

	
	
}
