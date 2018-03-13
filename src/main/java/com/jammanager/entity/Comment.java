package com.jammanager.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "comments")
public class Comment {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;
	
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

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
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
		return "Comment [id=" + id + ", time=" + dateTime + ", text=" + text + ", user=" + user + "]";
	}

    
}
