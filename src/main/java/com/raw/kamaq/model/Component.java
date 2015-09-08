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
@Table(name = "COMPONENT")
public class Component {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COMPONENTID")
	private int componentId;

	@Column(name = "NAME", length = 80)
	private String name;

	@Column(name = "DESCRIPTION", length = 100)
	private String description;

	@Column(name = "CLASSNAME", length = 80)
	private String classname;

	@Column(name = "IMAGEFILENAME", length = 200)
	private String imageFileName;

	@ManyToOne(cascade = CascadeType.ALL)
	private Module module;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "component")
	private Set<Function> functions = new HashSet<Function>();

	public int getComponentId() {
		return componentId;
	}

	public void setComponentId(int componentId) {
		this.componentId = componentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public Set<Function> getFunctions() {
		return functions;
	}

	public void setFunctions(Set<Function> functions) {
		this.functions = functions;
	}

}
