package com.org.clg.admin.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Product")
public class Product {
	
	@Id
	@GenericGenerator(strategy="increment", name = "abc")
	@GeneratedValue(generator="abc")
	private long id;
	
	@Column(name="name")
	private String name;

	@Column(name="categoryname")
	private String name;
	
	@Column(name="size")
	private String size;
	
	@Column(name="price")
	private String price;
	
	@Column(name="description")
	private String description;

	 @ManyToOne(fetch = FetchType.LAZY)

	public Product() {
		
	}
	
	public Product(int id,  String name String categoryname, String size, String price, String description) {
		super();
		this.id = id;
		this.name = name;
		this.categoryname= categoryname;
		this.size = size;
		this.price = price;
		this.description = description;
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

	public String getCategoryName() {
		return categoryname;
	}

	public void setCategoryName(String categoryname) {
		this.categoryname= categoryname;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((categoryname == null) ? 0 : categoryname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (categoryname == null) {
			if (other.categoryname != null)
				return false;
		} else if (!categoryname.equals(other.categoryname))
			return false;	
		return true;
	}
}
