package com.onechurch.client.addchurch;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.onechurch.shared.ChurchInfo;



@RemoteServiceRelativePath("addchurchservice")
public interface AddChurchService extends RemoteService {
	String sentInfoToServer(String name, String location,
			String emailAddress, String contactNumber, String prayerRequest, String denomination,
			String description) throws IllegalArgumentException;
	List<ChurchInfo> getInfoFromServer();
}
