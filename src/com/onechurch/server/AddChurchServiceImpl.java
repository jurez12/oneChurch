
package com.onechurch.server;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.onechurch.client.addchurch.AddChurchService;
import com.onechurch.shared.ChurchInfo;

public class AddChurchServiceImpl extends RemoteServiceServlet implements
 AddChurchService {
	
	private static final long serialVersionUID = 1L;
	Objectify ofy = ObjectifyService.begin();
	
//	static {
//		ObjectifyService.register(ChurchInfo.class);
//	}
	final int MAX_CHAT_LIMIT = 25;
	List<String> foulWordsList = new ArrayList<String>(Arrays.asList("sex", "shit", "rascal"));
	
	public String sentInfoToServer(String name, String denomination, String address,
			String serviceLanguages, String emailAddress, String contactNumber, String website, String churchImage,
			 String mediaInfo, String eventInfo, String description, String prayerRequest,
			String adminName, String adminAddress, String adminContactNumber,
			String adminEmailAddress, String adminPassword) throws IllegalArgumentException {
		String lowerCase  = description.toLowerCase();
		
		for(String foulWord : foulWordsList ) {
			if(lowerCase.contains(foulWord)) {
				return "Error : please dont entery bad words, you description messsage is " + description;
			}
		}
		ChurchInfo churchInfo = new ChurchInfo();
		churchInfo.setName(name);
		churchInfo.setDenomination(denomination);
		churchInfo.setAddress(address);
		churchInfo.setServiceLanguages(serviceLanguages);
		churchInfo.setEmailAddress(emailAddress);
		churchInfo.setContactNumber(contactNumber);
		churchInfo.setWebsite(website);
		churchInfo.setChurchImage(churchImage);
		churchInfo.setMediaInfo(mediaInfo);
		churchInfo.setEventInfo(eventInfo);
		churchInfo.setDescription(description);
		churchInfo.setPrayerRequest(prayerRequest);
		churchInfo.setAdminName(adminName);
		churchInfo.setAdminAddress(adminAddress);
		churchInfo.setAdminContactNumber(adminContactNumber);
		churchInfo.setAdminEmailAddress(adminEmailAddress);
		churchInfo.setAdminPassword(adminPassword);
		
		Calendar cal = new GregorianCalendar(TimeZone.getTimeZone("GMT+530"));
		cal.setTime(new Date());
		churchInfo.setCreateDate(cal.getTime());
	
		
//		List<ChurchInfo>  churchInfoList = ofy.query(ChurchInfo.class).order("createDate").list();
//		for(ChurchInfo churchInfoDb : churchInfoList) {
//			if(churchInfoDb.getName().contains(name)){
//				return "Error : Church Name " + name + " already exist";
//			}
//		}
		
		ofy.put(churchInfo);
		
		return "Added " + churchInfo.getName() + " successfully";
	}
	
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
