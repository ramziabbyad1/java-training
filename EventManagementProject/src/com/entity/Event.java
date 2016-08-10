package com.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;






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
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.metamodel.binding.CascadeType;
@Entity(name="event")
@Table(name="event")
public class Event {
	private int id;
	private String name;
	private Set<Speaker> speakers = new HashSet<>();
	private Set<Attendee> attendees = new HashSet<>();
	private Date startDate;
	private Location location;
	public Event(){}
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
	@OneToMany
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	@JoinColumn(name="event_id")
	public Set<Speaker> getSpeakers() {
		return speakers;
	}
	
	public void addSpeaker(Speaker speaker){
		getSpeakers().add(speaker);
	}
	
	protected void setSpeakers(Set<Speaker> speakers) {
		this.speakers = speakers;
	}
	
	@Column(name="start_date")
	@Temporal(TemporalType.DATE)
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	@ManyToOne
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	@JoinColumn(name="location_id")
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Event [id=" + id + ", name=" + name + ", startDate="
				+ startDate + "]";
	}
	@ManyToMany
	@JoinTable(
		name = "event_attendee",
		joinColumns = {@JoinColumn(name="event_id")},
		inverseJoinColumns={@JoinColumn(name="attendee_id")}
	)
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	public Set<Attendee> getAttendees() {
		return attendees;
	}
	public void setAttendees(Set<Attendee> attendees) {
		this.attendees = attendees;
	}

	
}
