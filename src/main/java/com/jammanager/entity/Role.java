package com.jammanager.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	@ManyToMany
	@JoinTable(name = "users_roles",
	joinColumns = @JoinColumn(name = "role_id"),
	inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> users;
	
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

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}
	
	
}
