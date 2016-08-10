package com.example.manytomany;

import java.util.Date;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="user_details")
public class UserDetails {
	@Id
	@GeneratedValue
	@Column(name="user_id")
	private int userId;
	@Column(name="user_name", nullable=false, length=30)
	private String userName;
	@Temporal(TemporalType.DATE)
	private Date dob;
	@ManyToMany
	private List<Address> addresses;
	public UserDetails(){}
	public UserDetails(String userName, Date dob,List<Address> addresses){
		this.userName = userName;
		this.addresses = addresses;
		this.dob = dob;
	}
	public int getUserId() {
		return userId;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
}
