package com.onechurch.client.addchurch;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.onechurch.shared.ChurchInfo;



@RemoteServiceRelativePath("addchurchservice")
public interface AddChurchService extends RemoteService {
	
//	private String name;
//	public String denomination;
//	private String address;
//	private String serviceLanguages;
//	private String emailAddress;
//	private String contactNumber;
//	private String mediaInfo;
//	private String eventInfo;
//	private String description = "";
//	private String prayerRequest;
//	private String adminName;
//	private String adminAddress;
//	private String adminContactNumber;
//	private String adminEmailAddress;
//	private String adminPassword
	
	String sentInfoToServer(String name, String denomination, String address,
			String serviceLanguages, String emailAddress, String contactNumber, String website, String churchImage,
			 String mediaInfo, String eventInfo, String description, String prayerRequest,
			String adminName, String adminAddress, String adminContactNumber,
			String adminEmailAddress, String adminPassword) throws IllegalArgumentException;
	List<ChurchInfo> getInfoFromServer();
}
