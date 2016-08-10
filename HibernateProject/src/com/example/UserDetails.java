package com.example;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="user_details")
public class UserDetails {
	@Id
	@GeneratedValue
	@Column(name="user_id")
	private int userId;
	@Column(name="user_name", nullable=false, length=30)
	private String userName;
	@Column(name="date_of_birth")
	@Temporal(TemporalType.TIME)
	private Date dob;
	//@OneToMany(cascade=CascadeType.ALL)
	@OneToMany
	@JoinColumn(name = "user_id")
	private List<Address> addresses;
	@Lob
	private String comments;
	public UserDetails(){}
	public UserDetails(String userName, Date dob, List<Address> addresses){
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
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
}
