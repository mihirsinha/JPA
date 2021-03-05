package com.abc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.abc.bean.Product;
import com.abc.util.DBUtil;

public class ProductDAO {
	
	public boolean insert(Product product) {
		
		boolean flag = false;
		
		Connection con = DBUtil.getDBConnection();

		String sql = "insert into product_tbl values(?,?,?)";

		try {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, product.getProductId());
			ps.setString(2, product.getName());
			ps.setDouble(3, product.getPrice());
			
			int result = ps.executeUpdate();
			
			if(result == 1) {
				flag = true;
			}			

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			DBUtil.closeDBConnection(con);
		}	
		
		return flag;		
	}
	
	public Product fetchProductById(int productId) {
		
		Connection con = DBUtil.getDBConnection();

		String sql = "select * from product_tbl where product_id = ?";
		
		Product product = null;
		
		try {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, productId);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {					 
				product = new Product();
				product.setProductId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setPrice(rs.getDouble(3));				  
			}	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			DBUtil.closeDBConnection(con);
		}	
		
		return product;
		
	}
		
	public List<Product> fetchAllProducts() {
		
		Connection con = DBUtil.getDBConnection();
		
		String sql = "select * from product_tbl";	
		
		List<Product> products = new ArrayList<Product>();		
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Product product = new Product();
				product.setProductId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setPrice(rs.getDouble(3));	
				
				products.add(product);
				
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.closeDBConnection(con);
		}
		
      return products;	
		
	}
	
	public void update() {
		
	}
	
	public void delete() {
		
	}
	
	public void select() {
		
	}
	
}
