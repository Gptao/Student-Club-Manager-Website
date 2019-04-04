package com.nankai.app.domain;

// Generated 2017-7-20 17:13:46 by Hibernate Tools 3.4.0.CR1

/**
 * Activity generated by hbm2java
 */
public class Activity implements java.io.Serializable {

	private Integer activityId;
	private Organization organization;
	private String activityName;
	private String activityLocation;
	private String activityPicture;
	private String activityIntroduction;
	private String activityTime;
	private String activityContent;

	public Activity() {
	}

	public Activity(Organization organization, String activityName,
			String activityLocation, String activityPicture,
			String activityIntroduction, String activityTime,
			String activityContent) {
		this.organization = organization;
		this.activityName = activityName;
		this.activityLocation = activityLocation;
		this.activityPicture = activityPicture;
		this.activityIntroduction = activityIntroduction;
		this.activityTime = activityTime;
		this.activityContent = activityContent;
	}

	public Integer getActivityId() {
		return this.activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public Organization getOrganization() {
		return this.organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public String getActivityName() {
		return this.activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getActivityLocation() {
		return this.activityLocation;
	}

	public void setActivityLocation(String activityLocation) {
		this.activityLocation = activityLocation;
	}

	public String getActivityPicture() {
		return this.activityPicture;
	}

	public void setActivityPicture(String activityPicture) {
		this.activityPicture = activityPicture;
	}

	public String getActivityIntroduction() {
		return this.activityIntroduction;
	}

	public void setActivityIntroduction(String activityIntroduction) {
		this.activityIntroduction = activityIntroduction;
	}

	public String getActivityTime() {
		return this.activityTime;
	}

	public void setActivityTime(String activityTime) {
		this.activityTime = activityTime;
	}

	public String getActivityContent() {
		return this.activityContent;
	}

	public void setActivityContent(String activityContent) {
		this.activityContent = activityContent;
	}

}