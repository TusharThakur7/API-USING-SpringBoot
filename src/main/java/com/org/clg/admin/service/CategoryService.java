package com.org.clg.admin.service;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.org.clg.admin.dao.CategoryRepository;
import com.org.clg.admin.entity.Category;


@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	public List<Category> all()
	{
		return (List<Category>) categoryRepository.findAll();
	}
	
	public Category getCategoryById(long id)
	{
		Optional<Category> opt = categoryRepository.findById(id);
		
		if(opt.isPresent())
			return opt.get();
		else
			return null;
	}
	
	
	
	@Transactional
	public Category add(Category category)
	{
		return categoryRepository.save(category);
	}
	
	@Transactional
	public Category update(Category category,long id)
	{
		Optional<Category> op = categoryRepository.findById(id);
		if(op.isPresent())
		{
			Category c = op.get();
			c.setBrand(category.getBrand());
			c.setCategoryName(category.getCategoryName());
			c.setDetails(category.getDetails());
			return categoryRepository.save(c);
		}
		
		return null;
	}
	
	@Transactional
	public void deletecategory(long id)
	{
		categoryRepository.deleteById(id);
	}
}

