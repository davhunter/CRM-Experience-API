package com.deloitte.system.customer.cdm;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonAutoDetect;

/**
 * Simple POJO for holding Product info
 * 
 * @author David Hunter (Deloitte)
 */
@JsonAutoDetect
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;

	public Product(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Product() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
