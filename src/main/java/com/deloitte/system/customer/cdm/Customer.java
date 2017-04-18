package com.deloitte.system.customer.cdm;

import java.io.Serializable;
import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Simple POJO for holding Customer info
 * 
 * @author David Hunter (Deloitte)
 */
@JsonAutoDetect
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String firstName;
	private String lastName;
	private String region;
	private String phone;
	@JsonSerialize(include=JsonSerialize.Inclusion.NON_EMPTY)
	private ArrayList<Product> products = new ArrayList<Product>();

	public Customer(int id, String firstName, String lastName, String region, String phone, ArrayList<Product> products) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.region = region;
		this.phone = phone;
		this.products = products;
	}

	public Customer() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
}
