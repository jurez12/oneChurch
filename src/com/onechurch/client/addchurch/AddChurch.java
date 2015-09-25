package com.onechurch.client.addchurch;

import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.onechurch.shared.ChurchInfo;



public class AddChurch implements EntryPoint {
	
	AddChurchServiceAsync addChurchService = GWT.create(AddChurchService.class);
	
	final Image image = new Image();

	@Override
	public void onModuleLoad() {
		setChurchInfoRpc("apfc ", "bangalore, center", "email", "83234", "req", "deno",
				"desc");
		getChurchInfoRpc();

	}

	private void setChurchInfoRpc(String name, String location,
			String emailAddress, String contactNumber, String prayerRequest, String  denomiation,
			String description) {
		addChurchService.sentInfoToServer(name, location, emailAddress,
				contactNumber, prayerRequest, denomiation,  description,
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
