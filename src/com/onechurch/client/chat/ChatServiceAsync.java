package com.onechurch.client.chat;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.onechurch.shared.ChatInfo;



public interface ChatServiceAsync {

	void sentInfoToServer(String chatInfo, String userName, AsyncCallback<String> callback)
			throws IllegalArgumentException;
	
	void getInfoFromServer(AsyncCallback<List<ChatInfo>> callback)
			throws IllegalArgumentException;
}
