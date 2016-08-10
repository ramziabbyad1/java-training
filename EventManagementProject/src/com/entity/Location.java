package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="location")
@Table(name="location")
public class Location {
	private int id;
	private String name;
	private String address;
	public Location(){}
	public Location(String name, String address){
		this.name=name;
		this.address = address;
	}
	@Id @GeneratedValue
	public int getId() {
		return id;
	}
	private void setId(int id) {
		this.id = id;
	}
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Location [id=" + id + ", name=" + name + ", address=" + address
				+ "]";
	}
	
}
