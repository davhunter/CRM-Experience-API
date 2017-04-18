package com.deloitte.productapi.cdm;

import java.io.Serializable;
import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
public class Products implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<Product> products = new ArrayList<Product>();

	public Products(ArrayList<Product> products) {
		super();
		this.products = products;
	}

	public Products() {
		super();
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
}
