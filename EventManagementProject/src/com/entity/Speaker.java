package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="speaker")
public class Speaker {
	private int id;
	private String name;
	private String telephone;
	public Speaker(){}
	public Speaker(String name, String telephone){
		this.name=name;
		this.telephone=telephone;
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
	@Column(name="telephone")
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	@Override
	public boolean equals(Object o){
		if(!(o instanceof Speaker)){
			return false;
		}
		return (this.name==((Speaker)o).name && this.telephone==((Speaker)o).telephone);
	}
	@Override
	public int hashCode(){
		return (name+telephone).hashCode();
	}
	@Override
	public String toString() {
		return "Speaker [id=" + id + ", name=" + name + ", telephone="
				+ telephone + "]";
	}
	
	
}
