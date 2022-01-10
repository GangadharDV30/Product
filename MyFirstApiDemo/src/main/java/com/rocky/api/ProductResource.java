package com.rocky.api;

import java.sql.SQLException;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.product.bean.Product;
import com.product.service.ProductService;
import com.product.service.ProductServiceImpl;

@Path("/products")
public class ProductResource {
	

		private ProductService productService=new ProductServiceImpl();
		
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public List<Product> listAllProducts(){
			try {
				return productService.viewAllProducts();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		
		@Path("/code/{code}")
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public Product getProductByCode(@PathParam("code") String code) {
			try {
				return productService.getProductByCode(code);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public boolean addProduct(Product c) 
		{ 
			try {
				return productService.insertProduct(c);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			return false;
		}
		
//		@Path("/delete/{delete}")
//		@DELETE
//		@Produces(MediaType.APPLICATION_JSON)
//		public boolean deleteProduct(@PathParam("delete")String pName)
//		{
//			try {
//				return productService.deleteProduct(pName);
//			} catch (ClassNotFoundException | SQLException e) {
//				e.printStackTrace();
//			}
//			return false;
		
		
		@Path("/delete/{delete}")
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public boolean deleteProduct(@PathParam("delete")String pName)
		{
			try {
				return productService.deleteProduct(pName);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			return false;
		}
}
