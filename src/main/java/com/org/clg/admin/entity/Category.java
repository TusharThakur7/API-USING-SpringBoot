package com.org.clg.admin.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Category")
public class Category {
	
	@Id
	@GenericGenerator(strategy="increment", name = "abc")
	@GeneratedValue(generator="abc")
	private long id;
	
	@Column(name="categoryname")
	private String categoryname;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="details")
	private String details;

	public Category() {
		
	}
	
	public Category(int id, String categoryname , String brand, String details) {
		super();
		this.id = id;
		this.categoryname = categoryname;
		this.brand = brand;
		this.details = details;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryname;
	}

	public void setCategoryName(String categoryname) {
		this.categoryname =categoryname;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((details == null) ? 0 : details.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Category other = (Category) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (details == null) {
			if (other.details != null)
				return false;
		} else if (!details.equals(other.details))
			return false;
		if (id != other.id)
			return false;
		if (categoryname == null) {
			if (other.categoryname != null)
				return false;
		} else if (!categoryname.equals(other.categoryname))
			return false;
		return true;
	}
}


