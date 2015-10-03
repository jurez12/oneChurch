package com.onechurch.client.addchurch;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.onechurch.shared.ChurchInfo;

public interface AddChurchServiceAsync {

	void sentInfoToServer(String name, String denomination, String address,
			String serviceLanguages, String emailAddress, String contactNumber, String website,  String churchImage,
			 String mediaInfo, String eventInfo, String description, String prayerRequest,
			String adminName, String adminAddress, String adminContactNumber,
			String adminEmailAddress, String adminPassword, AsyncCallback<String> callback)
			throws IllegalArgumentException;
	
	void getInfoFromServer(AsyncCallback<List<ChurchInfo>> callback)
			throws IllegalArgumentException;
}
