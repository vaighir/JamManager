package com.jammanager.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cities")
public class City {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	@OneToMany(mappedBy = "city")
	private List<User> users;
	
	@OneToMany(mappedBy = "city")
	private List<Jam> jams;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Jam> getJams() {
		return jams;
	}

	public void setJams(List<Jam> jams) {
		this.jams = jams;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", jams:" + jams.size() + "]";
	}
	
	
}
