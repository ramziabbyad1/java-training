package com.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="attendee")
public class Attendee {
	private int id;
	private String name;
	private String telephone;
	private Set<Event> events = new HashSet<>();
	public Attendee(){}
	public Attendee(String name, String telephone){
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
		if(!(o instanceof Attendee)){
			return false;
		}
		return (this.name==((Attendee)o).name && this.telephone==((Attendee)o).telephone);
	}
	@Override
	public int hashCode(){
		return (name+telephone).hashCode();
	}
	@Override
	public String toString() {
		return "Attendee [id=" + id + ", name=" + name + ", telephone="
				+ telephone + "]";
	}
	@ManyToMany(mappedBy="attendees")
	public Set<Event> getEvents() {
		return events;
	}
	public void setEvents(Set<Event> events) {
		this.events = events;
	}
}
