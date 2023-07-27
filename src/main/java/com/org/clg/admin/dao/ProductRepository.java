package com.org.clg.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.org.clg.admin.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	public Product findByName(String name);
	
	@Query("SELECT p FROM Product p where p.name=:name")
	public Product findByNameV1(String name);
	
	public Product findByNameAndSize(String name,String size);
	
	public void deleteById(long id);
	
	//@Query("DELETE FROM Brand b where b.name=:name")
	public Product deleteByName(String name);
	
}
