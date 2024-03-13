package com.springboot.bookstore.entity;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "order_entity")
public class OrderEntity {

    @Id
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User idUser;
    
    @Column(name = "total")
    private Double total;
    
    @Column(name = "date")
    private Date date;

	public OrderEntity(int id, User idUser, Double total, Date date) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.total = total;
		this.date = date;
	}

	public OrderEntity() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getIdUser() {
		return idUser;
	}

	public void setIdUser(User idUser) {
		this.idUser = idUser;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "OrderEntity [id=" + id + ", idUser=" + idUser + ", total=" + total + ", date=" + date + "]";
	}

}
