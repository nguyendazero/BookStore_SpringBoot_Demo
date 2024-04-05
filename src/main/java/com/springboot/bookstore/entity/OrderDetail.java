package com.springboot.bookstore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "order_detail")
public class OrderDetail {

    @EmbeddedId
    private OrderDetailId id;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "id_order")
    private OrderEntity order;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "id_product")
    private Product product;

    @Column(name = "quantity")
    private int quantity;

	public OrderDetail(OrderDetailId id, OrderEntity order, Product product, int quantity) {
		super();
		this.id = id;
		this.order = order;
		this.product = product;
		this.quantity = quantity;
	}

	public OrderDetail() {

	}

	public OrderDetailId getId() {
		return id;
	}

	public void setId(OrderDetailId id) {
		this.id = id;
	}

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", order=" + order + ", product=" + product + ", quantity=" + quantity
				 + "]";
	}
	
	
}
