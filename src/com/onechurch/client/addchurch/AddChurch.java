package com.onechurch.client.addchurch;

import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.onechurch.shared.ChurchInfo;



public class AddChurch implements EntryPoint {
	
	AddChurchServiceAsync addChurchService = GWT.create(AddChurchService.class);
	
	final Image image = new Image();
	FlexTable addChurchTable = new FlexTable();
	VerticalPanel mainVerticalPanel = new VerticalPanel();
	HorizontalPanel addChurchHorizontalPanel = new HorizontalPanel();
	
	//name,  denomination,  address,
//	 serviceLanguages,  emailAddress,  contactNumber, churchImage,
//	  mediaInfo,  eventInfo,  description,  prayerRequest,
//	 adminName,  adminAddress,  adminContactNumber,
//	 adminEmailAddress,  adminPassword,
	
	TextBox name = new TextBox();
	TextBox denomination = new TextBox();
	TextArea address = new TextArea();
	TextBox serviceLanguages = new TextBox();
	TextBox emailAddress = new TextBox();
	TextBox contactNumber = new TextBox();
	TextBox website = new TextBox();
	TextBox churchImage = new TextBox();
	TextArea mediaInfo = new TextArea();
	TextArea eventInfo = new TextArea();
	TextArea description = new TextArea();
	TextArea prayerRequest = new TextArea();
	TextBox adminName = new TextBox();
	TextBox adminAddress = new TextBox();
	TextBox adminContactNumber = new TextBox();
	TextArea adminEmailAddress = new TextArea();
	TextBox adminPassword = new TextBox();
	
	Button submitChurchInfoButton = new Button ("Add Church");
	
	@Override
	public void onModuleLoad() {
		
		addChurchHorizontalPanel.add(addChurchTable);
		
		int row = 0;
		addChurchTable.setWidget(row, 0, new HTML("<b style=\"color: #FFFFFF;\">Church Name :</b>") );
		addChurchTable.setWidget(row, 1, name);
		row++;
		addChurchTable.setWidget(row, 0, new HTML("<b style=\"color: #FFFFFF;\">Denomiation :</b>") );
		addChurchTable.setWidget(row, 1, denomination);
		row++;
		addChurchTable.setWidget(row, 0, new HTML("<b style=\"color: #FFFFFF;\">Church Address :</b>") );
		addChurchTable.setWidget(row, 1, address);
		row++;
		addChurchTable.setWidget(row, 0, new HTML("<b style=\"color: #FFFFFF;\">Service Langugaes :</b>") );
		addChurchTable.setWidget(row, 1, serviceLanguages);
		row++;
		addChurchTable.setWidget(row, 0, new HTML("<b style=\"color: #FFFFFF;\">Church Email Id :</b>") );
		addChurchTable.setWidget(row, 1, emailAddress);
		row++;
		addChurchTable.setWidget(row, 0, new HTML("<b style=\"color: #FFFFFF;\">Church Contact Number :</b>") );
		addChurchTable.setWidget(row, 1, contactNumber);
		row++;
		addChurchTable.setWidget(row, 0, new HTML("<b style=\"color: #FFFFFF;\">Church Website :</b>") );
		addChurchTable.setWidget(row, 1, website);
		row++;
		addChurchTable.setWidget(row, 0, new HTML("<b style=\"color: #FFFFFF;\">Church Image link :</b>") );
		addChurchTable.setWidget(row, 1, churchImage);
		row++;
		addChurchTable.setWidget(row, 0, new HTML("<b style=\"color: #FFFFFF;\">Church Media Info :</b>") );
		addChurchTable.setWidget(row, 1, mediaInfo);
		row++;
		addChurchTable.setWidget(row, 0, new HTML("<b style=\"color: #FFFFFF;\">Church Event Info :</b>") );
		addChurchTable.setWidget(row, 1, eventInfo);
		row++;
		
		addChurchTable.setWidget(row, 0, new HTML("<b style=\"color: #FFFFFF;\">Church Description :</b>") );
		addChurchTable.setWidget(row, 1, description);
		row++;
		addChurchTable.setWidget(row, 0, new HTML("<b style=\"color: #FFFFFF;\">Church Prayer Request :</b>") );
		addChurchTable.setWidget(row, 1, prayerRequest);
		row++;
		addChurchTable.setWidget(row, 0, new HTML("<b style=\"color: #FFFFFF;\">Church Admin Name :</b>") );
		addChurchTable.setWidget(row, 1, adminName);
		row++;
		addChurchTable.setWidget(row, 0, new HTML("<b style=\"color: #FFFFFF;\">Church Admin Address :</b>") );
		addChurchTable.setWidget(row, 1, adminAddress);
		row++;
		addChurchTable.setWidget(row, 0, new HTML("<b style=\"color: #FFFFFF;\">Church Admin Contact Number :</b>") );
		addChurchTable.setWidget(row, 1, adminContactNumber);
		row++;
		addChurchTable.setWidget(row, 0, new HTML("<b style=\"color: #FFFFFF;\">Church Admin Email Address :</b>") );
		addChurchTable.setWidget(row, 1, adminEmailAddress);
		row++;
		addChurchTable.setWidget(row, 0, new HTML("<b style=\"color: #FFFFFF;\">Church Admin Password :</b>") );
		addChurchTable.setWidget(row, 1, adminPassword);
		row++;
		
		addChurchTable.setWidget(row, 1, submitChurchInfoButton);
		
		
		submitChurchInfoButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				setChurchInfoRpc(name.getValue(), denomination.getValue() ,address.getValue(),
						serviceLanguages.getValue(), emailAddress.getValue(),
						contactNumber.getValue(),website.getValue() , churchImage.getValue(),
						mediaInfo.getValue() ,eventInfo.getValue(),
						description.getValue(),prayerRequest.getValue(), adminName.getValue(),
						adminAddress.getValue(), adminContactNumber.getValue(),
						adminEmailAddress.getValue(), adminPassword.getValue());
				addChurchHorizontalPanel.clear();
				addChurchHorizontalPanel.add( new HTML("<b>Succesfully Added Church </b>"));
				
			}
		});
		RootPanel.get("main").add(addChurchHorizontalPanel);
		//getChurchInfoRpc();
	}

	private void setChurchInfoRpc(String name, String denomination, String address,
			String serviceLanguages, String emailAddress, String contactNumber,String website,
			String churchImage, String mediaInfo, String eventInfo, String description, String prayerRequest,
			String adminName, String adminAddress, String adminContactNumber,
			String adminEmailAddress, String adminPassword) {
		addChurchService.sentInfoToServer( name,  denomination,  address,
				 serviceLanguages,  emailAddress,  contactNumber, website, churchImage,
				  mediaInfo,  eventInfo,  description,  prayerRequest,
				 adminName,  adminAddress,  adminContactNumber,
				 adminEmailAddress,  adminPassword,
				new AsyncCallback<String>() {
					public void onFailure(Throwable caught) {
						image.setVisible(false);
					}

					public void onSuccess(String result) {
						if (result.contains("Error")) {
							Window.alert(result);
							image.setVisible(false);
							return;
						}
						
					}
				});
	}
	
	private void getChurchInfoRpc() {
		//image.setVisible(true);
		
		
		addChurchService.getInfoFromServer(new AsyncCallback<List<ChurchInfo>>() {

			@Override
			public void onFailure(Throwable caught) {
				//image.setVisible(false);
		        Window.alert("Failure!");
			}
	
			public void onSuccess(List<ChurchInfo> result) {
				//image.setVisible(false);
				//loadChaWithoutLoadImage(result);
			  //  timer.schedule(TIMER_MILISECONDS);
			}
		});
	}
	
}
