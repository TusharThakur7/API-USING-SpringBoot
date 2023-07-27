package com.org.clg.admin.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.org.clg.admin.entity.Category;
import com.org.clg.admin.entity.Product;
import com.org.clg.admin.service.CategoryService;
import com.org.clg.admin.service.ProductService;



@RestController
@RequestMapping("/api/")
public class AdminController {
	
	@Autowired
	private ProductService productService;
	private CategoryService categoryService;
	
	 //Our Controller For Categories
	
	@GetMapping("/Categories?page=3")
	public List<Category> getuser()
	{
		return categoryService.all();
	}
	
	@PostMapping("/categories")
	public Category add(@RequestBody Category category)
	{
		return categoryService.add(category);
	}
	
	@GetMapping("/categories/{id}")
	public Category getUserById(@PathVariable long id)
	{
		return categoryService.getCategoryById(id);
	}
	
	@PutMapping("/categories/{id}")
	public Category update(@RequestBody Category category,@PathVariable long id)
	{
		return categoryService.update(category, id);
	}
	
	@DeleteMapping("/categories/{id}")
	public void deleteuser(@PathVariable long id)
	{
		categoryService.deletecategory(id);
	}
     // Our Controller For Products
	
	@GetMapping("/products?page=2/")
	public List<Product> get()
	{
		return productService.all();
	}
	
	@PostMapping("/products/")
	public Product add(@RequestBody Product product)
	{
		return productService.add(product);
	}
	
	@GetMapping("/products/{id}")
	public Product getById(@PathVariable long id)
	{
		return productService.getById(id);
	}
	
	@PutMapping("/products/{id}")
	public Product update(@RequestBody Product product,@PathVariable long id)
	{
		return productService.update(product, id);
	}
	
	@DeleteMapping("/products/{id}")
	public void delete(@PathVariable long id)
	{
		productService.delete(id);
	}
	

}
