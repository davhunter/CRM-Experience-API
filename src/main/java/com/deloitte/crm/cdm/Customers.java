package com.deloitte.crm.cdm;

import java.io.Serializable;
import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonAutoDetect;

/**
 * POJO container, containing an <code>ArrayList</code> of Customer objects.
 * Leverages the @JsonAutoDetect annotation for serializing to JSON.
 * 
 * @author David Hunter (Deloitte)
 * @see com.deloitte.crm.cdm.Customer
 * @see org.codehaus.jackson.annotate.JsonAutoDetect
 */
@JsonAutoDetect
public class Customers implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<Customer> customers = new ArrayList<Customer>();

	public Customers(ArrayList<Customer> customers) {
		super();
		this.customers = customers;
	}

	public Customers() {
		super();
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}
}
