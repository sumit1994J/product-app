package productapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import productapp.model.Product;

@Component
public class ProductDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void createProduct(Product product)
	{
		this.hibernateTemplate.saveOrUpdate(product);
	}
	
	
	public List<Product> getProducts()
	{
		List<Product> products =this.hibernateTemplate.loadAll(Product.class);
		return products;
	}
	
	@Transactional
	public void deleteProduct(int pid) {
		Product pro=this.hibernateTemplate.load(Product.class,pid);
		this.hibernateTemplate.delete(pro);
	}
	
	public Product getProduct(int pid)
	{
		return this.hibernateTemplate.get(Product.class,pid);
		
	}

}
