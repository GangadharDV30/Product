package com.product.service;

import java.sql.SQLException;
import java.util.List;
import com.product.bean.Product;

public interface ProductService {
	List<Product> viewAllProducts()throws ClassNotFoundException,SQLException;
	public Product getProductByCode(String productCode)throws ClassNotFoundException,SQLException;
	public boolean insertProduct(Product product) throws ClassNotFoundException, SQLException;
	boolean deleteProduct(String pName)throws ClassNotFoundException,SQLException;
}
