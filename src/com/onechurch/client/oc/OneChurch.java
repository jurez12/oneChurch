package com.onechurch.client.oc;

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
import com.onechurch.client.addchurch.AddChurchService;
import com.onechurch.client.addchurch.AddChurchServiceAsync;
import com.onechurch.shared.ChurchInfo;

public class OneChurch implements EntryPoint {
	
	
	AddChurchServiceAsync addChurchService = GWT.create(AddChurchService.class);
	final Image image = new Image();
	FlexTable displayChurchTable = new FlexTable();
	VerticalPanel mainVerticalPanel = new VerticalPanel();
	HorizontalPanel displayChurchHorizontalPanel = new HorizontalPanel();
	
	//name,  denomination,  address,
//	 serviceLanguages,  emailAddress,  contactNumber, churchImage,
//	  mediaInfo,  eventInfo,  description,  prayerRequest,
//	 adminName,  adminAddress,  adminContactNumber,
//	 adminEmailAddress,  adminPassword,
	
	
	
	Button submitChurchInfoButton = new Button ("Add Church");
	
	@Override
	public void onModuleLoad() {
		
		displayChurchHorizontalPanel.add(displayChurchTable);
		getChurchesInfoRpc();
		RootPanel.get("display").add(new HTML("<b>Display  Churches</b>"));
		RootPanel.get("display").add(displayChurchHorizontalPanel);
	}
	
	private void getChurchesInfoRpc() {
		image.setVisible(true);
		
		
		addChurchService.getInfoFromServer(new AsyncCallback<List<ChurchInfo>>() {

			@Override
			public void onFailure(Throwable caught) {
				image.setVisible(false);
		        Window.alert("Failure!");
			}
	
			public void onSuccess(List<ChurchInfo> result) {
				image.setVisible(false);
				displayChurchesRpc(result);
			}
		});
	}
	
	private void displayChurchesRpc(List<ChurchInfo> churches) {
		int row = 0;
		for(ChurchInfo church : churches) {
			displayChurchTable.setText(row, 1, church.getName());
			displayChurchTable.setText(row, 2, church.getAddress());
			row++;
		}
	}

}
