package com.onechurch.client.oc;

import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.onechurch.shared.ChurchInfo;
import com.google.gwt.user.client.ui.Label;
public class OneChurch implements EntryPoint{
	
	
	OneChurchServiceAsync addChurchService = GWT.create(OneChurchService.class);
	final Image image = new Image();
	FlexTable displayChurchTable = new FlexTable();
	VerticalPanel mainVerticalPanel = new VerticalPanel();
	HorizontalPanel displayChurchHorizontalPanel = new HorizontalPanel();
	HorizontalPanel searchChurchHorizontalPanel = new HorizontalPanel();
	TextBox searchTextBox = new TextBox();
	//name,  denomination,  address,
//	 serviceLanguages,  emailAddress,  contactNumber, churchImage,
//	  mediaInfo,  eventInfo,  description,  prayerRequest,
//	 adminName,  adminAddress,  adminContactNumber,
//	 adminEmailAddress,  adminPassword,
	
	
	
	
	@Override
	public void onModuleLoad() {
		
		Button searchButton = new Button ("Search");
		searchChurchHorizontalPanel.add(searchTextBox);
		searchChurchHorizontalPanel.add(searchButton);
		displayChurchHorizontalPanel.add(displayChurchTable);
		image.setUrl("/images/loading.gif");
		image.setVisible(false);
		AbsolutePanel loadImagePanel = new AbsolutePanel ();
		loadImagePanel.add(image);
		RootPanel.get("display").add(loadImagePanel);
		RootPanel.get("display").add(searchChurchHorizontalPanel);
		RootPanel.get("display").add(displayChurchHorizontalPanel);
		
		searchButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				getChurchesInfoRpc();
			}
	      });
		getChurchesInfoRpc();
	}
	
	private void getChurchesInfoRpc() {
		image.setVisible(true);
		addChurchService.getInfoFromServer(new AsyncCallback<List<ChurchInfo>>() {

			@Override
			public void onFailure(Throwable caught) {
				image.setVisible(false);
		        Window.alert("Failure! " + caught);
			}
	
			public void onSuccess(List<ChurchInfo> result) {
				image.setVisible(false);
				displayChurchesRpc(result);
			}
		});
	}
	
	private void displayChurchesRpc(List<ChurchInfo> churches) {
		displayChurchTable.clear();
		int row = 0;
		displayChurchTable.addStyleName("FlexTable");
		displayChurchTable.setText(row, 1,  "");
		displayChurchTable.setText(row, 2,  "Church Description");
		displayChurchTable.setText(row, 3,  "");
		displayChurchTable.getRowFormatter().addStyleName(row,"FlexTable-Header");
		boolean found = false;
		row++;
		String searchValue = searchTextBox.getValue().toLowerCase().trim();
        
//        if (searchValue.length() < 3) {
//        	Window.alert("Enter Valid Search, Search Text " + searchValue + " is invalid");
//        	return;
//        }
		for(final ChurchInfo church : churches) {
			if(church.getDenomination().toLowerCase().contains(searchValue) || 
				church.getAddress().toLowerCase().contains(searchValue) ||  
				church.getServiceLanguages().toLowerCase().contains(searchValue) ||
				church.getName().toLowerCase().contains(searchValue)) {
				//Window.alert("Successful Search Text " + searchValue);
			try {
				found = true;
			String image ="<img src=" + church.getChurchImage() +
			" style=\"width:200px;height:200px;\">";
			String info = "<h3><table><tr><td><span style=\"color: #00D2FF;\">Church Name :</span></td><td><span style=\"color: #FFFFFF;\">" + church.getName() + "</span></td></tr>"; 
			info = info +"<tr><td><span style=\"color: #00D2FF;\">Denomiaition: </span></td><td><span style=\"color: #FFFFFF;\">"  +church.getDenomination() + "</span></td></tr>";
			info = info +"<tr><td><span style=\"color: #00D2FF;\">Address:</span></td><td><span style=\"color: #FFFFFF;\">"  +church.getAddress() + "</span></td></tr>";
			info = info +"<tr><td><span style=\"color: #00D2FF;\">Contact:</span></td><td><span style=\"color: #FFFFFF;\">"  +church.getContactNumber() + "</span></td></tr>";
			info = info +"<tr><td><span style=\"color: #00D2FF;\">Service Language and Time:</span></td><td><span style=\"color: #FFFFFF;\">"  +church.getServiceLanguages() + "</span></td></tr>";
			if (church.getWebsite().length() >3) {
				info = info +"<tr><td><span style=\"color: #00D2FF;\">Website:</span></td><td><span style=\"color: #FFFFFF;\">"  +church.getWebsite() + "</span></td></tr>";
			}		
			info = info + "</table></h3></div>";
			displayChurchTable.setWidget(row, 1,  new HTML(image));
			displayChurchTable.getFlexCellFormatter().setWidth(row, 2, "600px");
			displayChurchTable.setWidget(row, 2, new HTML(info));
			
			Button viewDetailsButton = new Button ("View Details");
			
			viewDetailsButton.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					// TODO Auto-generated method stub
		            MyDialog myDialog = new MyDialog(church);

		            int left = Window.getClientWidth()/ 2;
		            int top = Window.getClientHeight()/ 2;
		            myDialog.setPopupPosition(left, 0);
		            myDialog.show();				
					
				}
		      });
			 displayChurchTable.setWidget(row, 3, viewDetailsButton);
			 if ((row % 2) != 0) {
				 displayChurchTable.getRowFormatter().addStyleName(row, "FlexTable-OddRow1");
		      }
		      else {
		    	  displayChurchTable.getRowFormatter().addStyleName(row, "FlexTable-EvenRow1");
		      }
			row++;
			} catch(Exception e) {
				System.out.println("Error");
			}
			}
		}
		if (found==false) {
			displayChurchTable.setWidget(row, 2, new HTML("No Church Records found"));
		}
	}
	
	private static class MyDialog extends DialogBox {

	    public MyDialog(ChurchInfo church) {
	        // Set the dialog box's caption.
	         setText("Church Details... ");

	         // Enable animation.
	         setAnimationEnabled(true);

	         // Enable glass background.
	         setGlassEnabled(true);

	         // DialogBox is a SimplePanel, so you have to set its widget 
	         // property to whatever you want its contents to be.
	         Button ok = new Button("Close");
	         ok.addClickHandler(new ClickHandler() {
	            public void onClick(ClickEvent event) {
	               MyDialog.this.hide();
	            }
	         });

			String image ="<img src=" + church.getChurchImage() +
			" style=\"width:200px;height:200px;\"><br>";
	
			String info = image + "<h3><table><tr><td WIDTH=200><span style=\"color: #00D2FF;\">Church Name :</span></td><td WIDTH=200>" + church.getName() + "</td></tr>"; 
			info = info +"<tr><td><span style=\"color: #00D2FF;\">Denomiaition: </span></td><td WIDTH=200>"  +church.getDenomination() + "</td></tr>";
			info = info +"<tr><td><span style=\"color: #00D2FF;\">Address:</span></td><td WIDTH=200>"  +church.getAddress() + "</td></tr>";
			info = info +"<tr><td><span style=\"color: #00D2FF;\">Contact:</span></td><td WIDTH=200>"  + church.getContactNumber() + "</td></tr>";
			info = info +"<tr><td><span style=\"color: #00D2FF;\">Website:</span></td><td WIDTH=200>"  + church.getWebsite() + "</td></tr>";
			info = info +"<tr><td><span style=\"color: #00D2FF;\">Service Language and Time:</span></td><td WIDTH=200>"  +church.getServiceLanguages() + "</td></tr>";
			info = info +"<tr><td><span style=\"color: #00D2FF;\">Media Info:</span></td><td WIDTH=200>"  + church.getMediInfo() + "</td></tr>";
			info = info +"<tr><td><span style=\"color: #00D2FF;\">Prayer Request:</span></td><td WIDTH=200>"  + church.getPrayerRequest() + "</td></tr>";
			info = info +"<tr><td><span style=\"color: #00D2FF;\">Event Info:</span></td><td WIDTH=200>"  + church.getEventInfo() + "</td></tr>";
			info = info +"<tr><td><span style=\"color: #00D2FF;\">Description:</span></td><td>"  + church.getDescription() + "</td></tr>";
			info = info +"<tr><td><span style=\"color: #00D2FF;\">Admin Name:</span></td><td WIDTH=200>"  + church.getAdminName() + "</td></tr>";
			info = info +"<tr><td><span style=\"color: #00D2FF;\">Admin Address:</span></td><td>"  + church.getAdminAddress() + "</td></tr>";
			info = info +"<tr><td><span style=\"color: #00D2FF;\">Admin Email:</span></td><td>"  + church.getAdminEmailAddress() + "</td></tr></table></h3></div>";

			HTML churchDetails = new HTML(info);
						
	         VerticalPanel panel = new VerticalPanel();
	         panel.setHeight("150");
	         panel.setWidth("1000");
	         panel.setSpacing(10);
	         panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
	         panel.add(churchDetails);
	         panel.add(ok);

	         setWidget(panel);
	    }
	  }

}
