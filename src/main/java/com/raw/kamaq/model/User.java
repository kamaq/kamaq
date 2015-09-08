package com.raw.kamaq.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USERID")
	private int userId;

	@Column(name = "NAME", length = 80)
	private String name;

	@Column(name = "PASSWORD", length = 20)
	private String password;

	@Column(name = "EMAIL", length = 255)
	private String email;

	@Column(name = "ENABLED")
	private boolean enabled;

	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Profile> profiles = new HashSet<Profile>();

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Profile> getProfiles() {
		return profiles;
	}

	public void setProfile(Set<Profile> profiles) {
		this.profiles = profiles;
	}

}
