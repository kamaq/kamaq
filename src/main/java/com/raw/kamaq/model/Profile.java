package com.raw.kamaq.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PROFILE")
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROFILEID")
	private int profileId;

	@Column(name = "NAME", length = 80)
	private String name;

	@Column(name = "ENABLED")
	private boolean enabled;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "profile")
	private Set<ProfileDetail> profileDetail = new HashSet<ProfileDetail>();

	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<ProfileDetail> getProfileDetail() {
		return profileDetail;
	}

	public void setProfileDetail(Set<ProfileDetail> profileDetail) {
		this.profileDetail = profileDetail;
	}

}
