package model;

import java.util.ArrayList;
import java.util.List;

public class Category {
	
	private Integer id;
	private String name;
	private List<Product> products = new ArrayList<Product>();
	
	public Category(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void add(Product product) {
		products.add(product);
		
	}

}
