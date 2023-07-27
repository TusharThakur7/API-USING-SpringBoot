package com.org.clg.admin.dao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.org.clg.admin.entity.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	
	
	@Query("from Category  where categoryname=:cn")
	List<Category>getCategoryName(@Param("cn")String categoryname);
	
   
	
	public void deleteById(long id);
	
	
	
	
}


