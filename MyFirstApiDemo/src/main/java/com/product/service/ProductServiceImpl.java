package com.product.service;

import java.sql.SQLException;
import java.util.List;

import com.product.bean.Product;
import com.product.persistance.ProductDao;
import com.product.persistance.ProductDaoImpl;

public class ProductServiceImpl implements ProductService{
	ProductDao productDao=new ProductDaoImpl();
	
	@Override
	public List<Product> viewAllProducts() throws ClassNotFoundException, SQLException {
		
		return productDao.listAllProducts();
	}

	@Override
	public Product getProductByCode(String productCode) throws ClassNotFoundException, SQLException {
		Product product=productDao.getProductByCode(productCode);
		return product;
	}

	@Override
	public boolean insertProduct(Product product) throws ClassNotFoundException, SQLException {
		int rows=productDao.insertProduct(product);
		if(rows>0)
			return true;
		return false;
	}

	@Override
	public boolean deleteProduct(String pName) throws ClassNotFoundException, SQLException {
		int rows=productDao.deleteProduct(pName);
		if(rows>0)
			return true;
		return false;
	}

}
