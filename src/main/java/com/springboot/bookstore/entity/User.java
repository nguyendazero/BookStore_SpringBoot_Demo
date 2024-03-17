package com.springboot.bookstore.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "full_name")
	private String fullName;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "date_of_birth")
	private Date dateOfBirth;
	
	@Column(name = "telephone")
	private String telephone;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "role")
	private int role;

	public User(int id, String userName, String password, String fullName, String gender, String address,
			Date dateOfBirth, String telephone, String email, int role) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.gender = gender;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.telephone = telephone;
		this.email = email;
		this.role = role;
	}

	
	
	public User(String userName, String password, String fullName, String gender, String address, Date dateOfBirth,
			String telephone, String email, int role) {
		super();
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.gender = gender;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.telephone = telephone;
		this.email = email;
		this.role = role;
	}

	public User() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", fullName=" + fullName
				+ ", gender=" + gender + ", address=" + address + ", dateOfBirth=" + dateOfBirth + ", telephone="
				+ telephone + ", email=" + email + ", role=" + role + "]";
	}
	
	
	
}
