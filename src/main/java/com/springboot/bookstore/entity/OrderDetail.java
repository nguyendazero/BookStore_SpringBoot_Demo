package com.springboot.bookstore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "order_detail")
public class OrderDetail {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "order_id")
    private int orderId;

    @Column(name = "quantity")
    private int quantity;
    
    @Column(name = "product_name")
    private String productName;
    
    @Column(name = "category")
    private String category;
    
    @Column(name = "price")
    private Double price;

	public OrderDetail(int id, int orderId, int quantity, String productName, String category, double price) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.quantity = quantity;
		this.productName = productName;
		this.category = category;
		this.price = price;
	}
    
	public OrderDetail( int orderId, int quantity, String productName, String category, double price) {
		super();
		this.orderId = orderId;
		this.quantity = quantity;
		this.productName = productName;
		this.category = category;
		this.price = price;
	}

	public OrderDetail() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", orderId=" + orderId + ", quantity=" + quantity + ", productName="
				+ productName + ", category=" + category + ", price=" + price + "]";
	}
	
	
    
}
