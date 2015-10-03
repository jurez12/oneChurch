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
	public String denomination;
	private String address;
	private String serviceLanguages;
	private String emailAddress;
	private String contactNumber;
	private String website;
	private String churchImage;
	private String prayerRequest;
	private String mediaInfo;
	private String eventInfo;
	private String description = "";
	private String adminName;
	private String adminAddress;
	private String adminContactNumber;
	private String adminEmailAddress;
	private String adminPassword;
	private boolean delete = false;
	private Date createDate;

	@Transient Date loaded;
    @PostLoad void trackLoadedDate() { this.loaded = new Date(); }
	public String getChurchImage() {
		return churchImage;
	}

	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}

	public void setChurchImage(String churchImage) {
		this.churchImage = churchImage;
	}
	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminpassword) {
		this.adminPassword = adminpassword;
	}

	public String getServiceLanguages() {
		return serviceLanguages;
	}


	public void setServiceLanguages(String serviceLanguages) {
		this.serviceLanguages = serviceLanguages;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMediInfo() {
		return mediaInfo;
	}

	public void setMediaInfo(String mediainfo) {
		this.mediaInfo = mediainfo;
	}

	public String getEventInfo() {
		return eventInfo;
	}

	public void setEventInfo(String eventInfo) {
		this.eventInfo = eventInfo;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}


	public String getAdminAddress() {
		return adminAddress;
	}

	public void setAdminAddress(String adminAddress) {
		this.adminAddress = adminAddress;
	}

	public String getAdminEmailAddress() {
		return adminEmailAddress;
	}

	public void setAdminEmailAddress(String adminEmailAddress) {
		this.adminEmailAddress = adminEmailAddress;
	}

	public String getAdminContactNumber() {
		return adminContactNumber;
	}

	public void setAdminContactNumber(String adminContactNumber) {
		this.adminContactNumber = adminContactNumber;
	}


	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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
