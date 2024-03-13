package com.springboot.bookstore.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "comment")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "id_user")
	private User idUser;
	
	@ManyToOne
	@JoinColumn(name = "id_product")
	private Product idProduct;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "date")
	private Date date;

	public Comment(int id, User idUser, Product idProduct, String content, Date date) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.idProduct = idProduct;
		this.content = content;
		this.date = date;
	}
	
	public Comment() {
		
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

	public Product getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Product idProduct) {
		this.idProduct = idProduct;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", idUser=" + idUser + ", idProduct=" + idProduct + ", content=" + content
				+ ", date=" + date + "]";
	}
}
