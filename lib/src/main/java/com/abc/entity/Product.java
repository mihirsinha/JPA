package com.abc.entity;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
 
@Entity
@Table(name = "product_tbl")
 
@NamedQueries({
	@NamedQuery(name = "getAllProducts", query = "select p from Product p"),
    @NamedQuery(name = "getProductByName", query = "select p from Product p where p.name = :pname") ,
    @NamedQuery(name = "getSumOfPrices", query = "select sum(p.price) from Product p") 
})
 
public class Product { 
    @Id
    @Column(name = "product_id")
    private int productId;
 
    @Column(name = "name")
    private String name;
 
    private double price;
 
    public int getProductId() {
    	return productId;
    }
    public void setProductId(int productId) {
    	this.productId = productId;
    } 
    public String getName() {
    	return name;
    } 
    public void setName(String name) {
    	this.name = name;
    } 
    public double getPrice() {
    	return price;
    } 
    public void setPrice(double price) {
    	this.price = price;
    } 
}