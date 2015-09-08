package com.raw.kamaq.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "FUNCTION")
public class Function {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FUNCTIONID")
	private int functionId;

	@Column(name = "NAME", length = 80)
	private String name;

	@ManyToOne(cascade = CascadeType.ALL)
	private Component component;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "function")
	private Set<ProfileDetail> profileDetail = new HashSet<ProfileDetail>();

	public int getFunctionId() {
		return functionId;
	}

	public void setFunctionId(int functionId) {
		this.functionId = functionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Component getComponent() {
		return component;
	}

	public void setComponent(Component component) {
		this.component = component;
	}
}
