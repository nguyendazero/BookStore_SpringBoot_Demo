package com.springboot.bookstore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "product_name")
    private String productName;
    
    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;
    
    @Column(name = "price_selling")
    private Double priceSelling;
    
    @Column(name = "price_original")
    private Double priceOriginal;
    
    @Column(name = "image")
    private String image;
    
    @Column(name = "status")
    private String status;
    
    @Column(name = "description")
    private String description; // changed from 'describe' to 'description' to avoid conflict with keyword
    
    @Column(name = "likes") // changed from 'like' to 'likes' to avoid conflict with keyword
    private int likes; // changed from 'like' to 'likes' to avoid conflict with keyword
    
    @Column(name = "remain_quantity")
    private int remainQuantity;
    
    @ManyToOne
    @JoinColumn(name = "id_author")
    private Author author;

	public Product(int id, String productName, Category category, Double priceSelling, Double priceOriginal,
			String image, String status, String description, int likes, int remainQuantity, Author author) {
		super();
		this.id = id;
		this.productName = productName;
		this.category = category;
		this.priceSelling = priceSelling;
		this.priceOriginal = priceOriginal;
		this.image = image;
		this.status = status;
		this.description = description;
		this.likes = likes;
		this.remainQuantity = remainQuantity;
		this.author = author;
	}
	
	public Product(String productName, Category category, Double priceSelling, Double priceOriginal,
			String image, String status, String description, int likes, int remainQuantity, Author author) {
		super();
		this.productName = productName;
		this.category = category;
		this.priceSelling = priceSelling;
		this.priceOriginal = priceOriginal;
		this.image = image;
		this.status = status;
		this.description = description;
		this.likes = likes;
		this.remainQuantity = remainQuantity;
		this.author = author;
	}

	public Product() {
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Double getPriceSelling() {
		return priceSelling;
	}

	public void setPriceSelling(Double priceSelling) {
		this.priceSelling = priceSelling;
	}

	public Double getPriceOriginal() {
		return priceOriginal;
	}

	public void setPriceOriginal(Double priceOriginal) {
		this.priceOriginal = priceOriginal;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getRemainQuantity() {
		return remainQuantity;
	}

	public void setRemainQuantity(int remainQuantity) {
		this.remainQuantity = remainQuantity;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", category=" + category + ", priceSelling="
				+ priceSelling + ", priceOriginal=" + priceOriginal + ", image=" + image + ", status=" + status
				+ ", description=" + description + ", likes=" + likes + ", remainQuantity=" + remainQuantity
				+ ", author=" + author + "]";
	}
	
	
}
