package com.jammanager.entity;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "jams")
public class Jam {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private Date date;
//	private Calendar time;

	@Column(nullable = false)
	private String place;

	@Column(columnDefinition = "TEXT", nullable = false)
	private String description;

	@OneToMany
	@JoinColumn(name = "jam_id")
	private List<Comment> comments;

	@ManyToOne
	@JoinColumn(name = "founder_id")
	private User founder;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;

	@ManyToMany
	@JoinTable(name = "jams_users",
	joinColumns = @JoinColumn(name = "jam_id"),
	inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> users;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public User getFounder() {
		return founder;
	}

	public void setFounder(User founder) {
		this.founder = founder;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Jam [id=" + id + ", date=" + date + ", place=" + place + ", description=" + description + ", founder="
				+ founder + ", city=" + city + ", users amount: " + users.size() + "]";
	}
	
	
}
