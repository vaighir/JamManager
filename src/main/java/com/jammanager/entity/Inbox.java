package com.jammanager.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "inboxes")
public class Inbox {

	private final int MAX_SIZE = 50;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToOne
	@JoinColumn(name = "user")
	private User owner;
	
	@OneToMany
	private List<Message> messages;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public int getMessagesAmount() {
		return messages.size();
	}
	
	@Override
	public String toString() {
		return owner + "'s inbox; current size: " + getMessagesAmount();
	}
	
}
