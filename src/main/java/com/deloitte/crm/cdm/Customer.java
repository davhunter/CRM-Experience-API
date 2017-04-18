package com.deloitte.crm.cdm;

import java.io.Serializable;
import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * POJO containing properties for a Customer. Also includes an
 * <code>ArrayList</code> of Product objects.
 * 
 * Leverages the <code>@JsonAutoDetect</code> annotation for serializing to
 * JSON.
 * 
 * @author David Hunter (Deloitte)
 * @see com.deloitte.crm.cdm.Product
 * @see org.codehaus.jackson.annotate.JsonAutoDetect
 */
@JsonAutoDetect
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	private int ID;
	private String firstName;
	private String lastName;
	private String region;
	private String phone;
	@JsonSerialize(include = JsonSerialize.Inclusion.NON_EMPTY)
	private ArrayList<Product> products = new ArrayList<Product>();

	public Customer(int iD, String firstName, String lastName, String region, String phone,
			ArrayList<Product> products) {
		super();
		ID = iD;
		this.firstName = firstName;
		this.lastName = lastName;
		this.region = region;
		this.phone = phone;
		this.products = products;
	}

	public Customer() {
		super();
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
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
