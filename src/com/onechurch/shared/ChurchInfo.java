package com.onechurch.shared;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Transient;

import com.google.appengine.api.datastore.PostLoad;

public class ChurchInfo implements Serializable {
	@Id
	public Long id;
	private String name;
	private String location;
	private String emailAddress;
	private String contactNumber;
	private String prayerRequest;
	private String description = "";
	public String denomination;
	private Date createDate;
	private boolean delete = false;
	@Transient Date loaded;
    @PostLoad void trackLoadedDate() { this.loaded = new Date(); }
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
    public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getContactNumber() {
		return contactNumber;
	}
	
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	public String getPrayerRequest() {
		return prayerRequest;
	}
	
	public void setPrayerRequest(String prayerRequest) {
		this.prayerRequest = prayerRequest;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDenomination() {
		return denomination;
	}
	
	public void setDenomination(String denomiation) {
		this.denomination = denomiation;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}
}
