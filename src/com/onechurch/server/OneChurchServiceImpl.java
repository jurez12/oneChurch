package com.onechurch.server;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.onechurch.client.oc.OneChurchService;
import com.onechurch.shared.ChurchInfo;




public class OneChurchServiceImpl extends RemoteServiceServlet implements
    OneChurchService {
	
	private static final long serialVersionUID = 1L;
	Objectify ofy = ObjectifyService.begin();
	
	static {
		ObjectifyService.register(ChurchInfo.class);
	}
	final int MAX_CHAT_LIMIT = 25;


	@Override
	public List<ChurchInfo> getInfoFromServer() {
		List<ChurchInfo>  churchInfoList = ofy.query(ChurchInfo.class).filter("delete", false).order("createDate").list();
		for(ChurchInfo  churchInfo : churchInfoList) {
			log("Retreived chat " + churchInfo.getName());
		}
		//Loop the query results and add to the array
		log("----------Retreived " + churchInfoList.size() + " rows");
		return churchInfoList;
	}
	
	
 
}