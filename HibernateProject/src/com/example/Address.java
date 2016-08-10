package com.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ADDRESS")
public class Address {
	@Id
	@GeneratedValue
	@Column(name="id")
	private long addressId;
	@Column(name="street", nullable=false, length=100)
	private String street;
	@Column(name="city", nullable=false, length=50)
	private String city;
	@Column(name="state", nullable=false, length=20)
	private String state;
	@Column(name="zipcode", nullable=false, columnDefinition = "char(5)")
	private String zip;
	//@ManyToOne
	@ManyToOne
	private UserDetails userDetails;
	public Address(){}
	public Address(String street, String city, String state,String zip){
		this.street=street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	public long getId() {
		return addressId;
	}
	public void setId(long addressId) {
		this.addressId = addressId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
}
