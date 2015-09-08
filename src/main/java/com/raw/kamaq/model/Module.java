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
@Table(name = "MODULE")
public class Module {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MODULEID")
	private int moduleId;

	@Column(name = "NAME", length = 80)
	private String name;

	@Column(name = "DESCRIPTION", length = 100)
	private String description;

	@Column(name = "IMAGEFILENAME", length = 200)
	private String imageFileName;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "module")
	private Set<Component> components = new HashSet<Component>();

	public int getModuleId() {
		return moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
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

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public Set<Component> getComponents() {
		return components;
	}

	public void setComponents(Set<Component> components) {
		this.components = components;
	}

}
