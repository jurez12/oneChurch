package com.onechurch.client.addchurch;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.onechurch.shared.ChurchInfo;

public interface AddChurchServiceAsync {

	void sentInfoToServer(String name, String location,
			String emailAddress, String contactNumber, String prayerRequest, String denomiation,
			String description, AsyncCallback<String> callback)
			throws IllegalArgumentException;
	
	void getInfoFromServer(AsyncCallback<List<ChurchInfo>> callback)
			throws IllegalArgumentException;
}
