package com.deloitte.system.customer.cdm;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonAutoDetect;

/**
 * Simple POJO for holding a list of Customers
 * 
 * @author David Hunter (Deloitte)
 */
@JsonAutoDetect
public class Customers implements Serializable {
	private static final long serialVersionUID = 1L;
	private Customer[] customers;

	public Customers(Customer[] customers) {
		super();
		this.customers = customers;
	}

	public Customers() {
		super();
	}

	public Customer[] getCustomers() {
		return customers;
	}

	public void setCustomers(Customer[] customers) {
		this.customers = customers;
	}
}
