package model;

public class Product {
	
	private Integer id;
	private String name;
	private String description;
	
	public Product(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public Product(Integer id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return String.format("The product created is: %d, %s, %s", this.id, this.name, this.description);
	}

}
