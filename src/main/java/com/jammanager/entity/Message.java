package com.jammanager.entity;

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
@Table(name = "messages")
public class Message {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private Calendar time;
	
    @Column(columnDefinition="TEXT")
	private String text;
    
    @ManyToOne
	@JoinColumn(name = "sender_id")
	private User sender;
    
    @ManyToOne
    @JoinColumn(name = "receiver_id")
	private User receiver;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Calendar getTime() {
		return time;
	}

	public void setTime(Calendar time) {
		this.time = time;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", time=" + time + ", text=" + text + ", sender=" + sender + ", receiver="
				+ receiver + "]";
	}
    
    
}
