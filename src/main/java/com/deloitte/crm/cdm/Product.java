package com.deloitte.crm.cdm;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	private int ID;
	private String name;
	private String description;
	private String region;
	private float price;

	public Product(int iD, String name, String description, String region, float price) {
		super();
		ID = iD;
		this.name = name;
		this.description = description;
		this.region = region;
		this.price = price;
	}

	public Product() {
		super();
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}
