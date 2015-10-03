package com.onechurch.client.oc;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.onechurch.shared.ChurchInfo;

@RemoteServiceRelativePath("displaychurchservice")
public interface OneChurchService  extends RemoteService {
	
	List<ChurchInfo> getInfoFromServer();

}
