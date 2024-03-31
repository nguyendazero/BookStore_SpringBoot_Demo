package com.springboot.bookstore.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "author")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "full_name")
	private String fullName;
	
	@Column(name = "home_town")
	private String homeTown;
	
	@Column(name = "date_of_birth")
	private Date dateOfBirth;
	
	@Column(name = "story")
	private String story;
	
	@Column(name = "image")
	private String image;
	

	public Author(int id, String fullName, String homeTown, Date dateOfBirth, String story, String image) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.homeTown = homeTown;
		this.dateOfBirth = dateOfBirth;
		this.story = story;
		this.image = image;
	}
	
	public Author( String fullName, String homeTown, Date dateOfBirth, String story, String image) {
		super();
		this.fullName = fullName;
		this.homeTown = homeTown;
		this.dateOfBirth = dateOfBirth;
		this.story = story;
		this.image = image;
	}

	
	public Author() {

	}

	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getHomeTown() {
		return homeTown;
	}

	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", fullName=" + fullName + ", homeTown=" + homeTown + ", dateOfBirth=" + dateOfBirth
				+ ", story=" + story + ", image=" + image + "]";
	}
	
	
	
}
