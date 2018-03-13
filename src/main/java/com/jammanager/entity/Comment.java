package com.jammanager.entity;

import java.sql.Date;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private Date date;
	
    @Column(columnDefinition="TEXT")
	private String text;
    
    @ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
    
    @ManyToOne
    private Jam jam;
    

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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Jam getJam() {
		return jam;
	}

	public void setJam(Jam jam) {
		this.jam = jam;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", time=" + date + ", text=" + text + ", user=" + user + "]";
	}

    
}
