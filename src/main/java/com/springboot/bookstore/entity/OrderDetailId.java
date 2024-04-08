//package com.springboot.bookstore.entity;
//
//import java.io.Serializable;
//import java.util.Objects;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Embeddable;
//
//@Embeddable
//public class OrderDetailId implements Serializable {
//    private static final long serialVersionUID = 1L;
//
//    @Column(name = "order_id")
//    private int orderId;
//
//    @Column(name = "product_id")
//    private int productId;
//
//    public OrderDetailId() {}
//
//    public OrderDetailId(int orderId, int productId) {
//        this.orderId = orderId;
//        this.productId = productId;
//    }
//
//    // Getters and setters
//    public int getOrderId() {
//        return orderId;
//    }
//
//    public void setOrderId(int orderId) {
//        this.orderId = orderId;
//    }
//
//    public int getProductId() {
//        return productId;
//    }
//
//    public void setProductId(int productId) {
//        this.productId = productId;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        OrderDetailId that = (OrderDetailId) o;
//        return orderId == that.orderId && productId == that.productId;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(orderId, productId);
//    }
//}
