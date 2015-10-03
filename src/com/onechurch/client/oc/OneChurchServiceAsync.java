package com.onechurch.client.oc;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.onechurch.shared.ChurchInfo;

public interface OneChurchServiceAsync {
	
	
	void getInfoFromServer(AsyncCallback<List<ChurchInfo>> callback)
			throws IllegalArgumentException;

}
