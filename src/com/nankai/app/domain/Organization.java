package com.nankai.app.domain;

// Generated 2017-7-20 17:13:46 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Organization generated by hbm2java
 */
public class Organization implements java.io.Serializable {

	private Integer organizationId;
	private String organizationName;
	private int organizationLeader;
	private String organizationIntroduction;
	private Set departments = new HashSet(0);
	private Set activities = new HashSet(0);
	private Set materials = new HashSet(0);

	public Organization() {
	}

	public Organization(String organizationName, int organizationLeader,
			String organizationIntroduction) {
		this.organizationName = organizationName;
		this.organizationLeader = organizationLeader;
		this.organizationIntroduction = organizationIntroduction;
	}

	public Organization(String organizationName, int organizationLeader,
			String organizationIntroduction, Set departments, Set activities,
			Set materials) {
		this.organizationName = organizationName;
		this.organizationLeader = organizationLeader;
		this.organizationIntroduction = organizationIntroduction;
		this.departments = departments;
		this.activities = activities;
		this.materials = materials;
	}

	public Integer getOrganizationId() {
		return this.organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public String getOrganizationName() {
		return this.organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public int getOrganizationLeader() {
		return this.organizationLeader;
	}

	public void setOrganizationLeader(int organizationLeader) {
		this.organizationLeader = organizationLeader;
	}

	public String getOrganizationIntroduction() {
		return this.organizationIntroduction;
	}

	public void setOrganizationIntroduction(String organizationIntroduction) {
		this.organizationIntroduction = organizationIntroduction;
	}

	public Set getDepartments() {
		return this.departments;
	}

	public void setDepartments(Set departments) {
		this.departments = departments;
	}

	public Set getActivities() {
		return this.activities;
	}

	public void setActivities(Set activities) {
		this.activities = activities;
	}

	public Set getMaterials() {
		return this.materials;
	}

	public void setMaterials(Set materials) {
		this.materials = materials;
	}

}
