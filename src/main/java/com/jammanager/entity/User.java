package com.jammanager.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.mindrot.jbcrypt.BCrypt;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false, unique = true)
	private String username;
	
//	@Column(columnDefinition="default 'true'")
//	private boolean enabled = true;
	
	private String firstName;
	private String lastName;

	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	private String avatar;
	
	@Pattern(regexp = "^\\d+$")
	private String whatsapp;
	private String fb;
	
	@Pattern(regexp = "^\\d+$")
	private String gg;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	
	@OneToOne
	@JoinColumn(name = "inbox_id")
	private Inbox inbox;
	
	@OneToOne
	@JoinColumn(name = "outbox_id")
	private Outbox outbox;
	
	@OneToMany(mappedBy = "founder")
	private List<Jam> foundedJams;
	
	@ManyToMany
	@JoinTable(name = "users_instruments",
	joinColumns = @JoinColumn(name = "user_id"),
	inverseJoinColumns = @JoinColumn(name = "instrument_id"))
	private List<Instrument> instruments;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "jams_users",
	joinColumns = @JoinColumn(name = "user_id"),
	inverseJoinColumns = @JoinColumn(name = "jam_id"))
	private List<Jam> jams;

	@ManyToMany
	@JoinTable(name = "users_roles",
	joinColumns = @JoinColumn(name = "user_id"),
	inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Jam> getFoundedJams() {
		return foundedJams;
	}

	public void setFoundedJams(List<Jam> foundedJams) {
		this.foundedJams = foundedJams;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = BCrypt.hashpw(password, BCrypt.gensalt());
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getWhatsapp() {
		return whatsapp;
	}

//	public boolean isEnabled() {
//		return enabled;
//	}
//
//	public void setEnabled(boolean enabled) {
//		this.enabled = enabled;
//	}
	
	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}

	public String getFb() {
		return fb;
	}

	public void setFb(String fb) {
		this.fb = fb;
	}

	public String getGg() {
		return gg;
	}

	public void setGg(String gg) {
		this.gg = gg;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Inbox getInbox() {
		return inbox;
	}

	public void setInbox(Inbox inbox) {
		this.inbox = inbox;
	}

	public Outbox getOutbox() {
		return outbox;
	}

	public void setOutbox(Outbox outbox) {
		this.outbox = outbox;
	}

	public List<Instrument> getInstruments() {
		return instruments;
	}

	public void setInstruments(List<Instrument> instruments) {
		this.instruments = instruments;
	}

	public List<Jam> getJams() {
		return jams;
	}

	public void setJams(List<Jam> jams) {
		this.jams = jams;
	}

	public String[] getRolesAsArray() {
		String[] rolesArray = new String[roles.size()];
		for (int i = 0; i < roles.size(); i++) {
			rolesArray[i] = roles.get(i).getName();
		}
		return rolesArray;
	}
	
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", city=" + city + "]";
	}
	
}
