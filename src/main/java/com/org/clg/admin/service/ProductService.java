package com.org.clg.admin.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.org.clg.admin.dao.ProductRepository;
import com.org.clg.admin.entity.Product;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public List<Product> all(Integer page)
	{ 
		 Pageable pa=PageRequest.of(page);
	    Page<Product> productpage= categoryRepository.findAll(pa);
		return (List<Product>)productpage.getContent();
	}
	
	public Product getById(long id)
	{
		Optional<Product> opt = productRepository.findById(id);
		
		if(opt.isPresent())
			return opt.get();
		else
			return null;
	}
	
	public Product getByName(String name)
	{
		return productRepository.findByName(name);
	}
	
	@Transactional
	public Product add(Product product)
	{
		return productRepository.save(product);
	}
	
	@Transactional
	public Product update(Product product,long id)
	{
		Optional<Product> op = productRepository.findById(id);
		if(op.isPresent())
		{
			Product p = op.get();
			p.setSize(product.getSize());
			p.setPrice(product.getPrice());
			p.setName(product.getName());
			p.setCategoryName(product.getCategoryName());
			p.setDescription(product.getDescription());
			return productRepository.save(p);
		}
		
		return null;
	}
	
	@Transactional
	public void delete(long id)
	{
		productRepository.deleteById(id);
	}
}
