package com.onechurch.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.onechurch.shared.PatientInfo;



public interface OneChurchServiceAsync {

  void getBlobStoreUploadUrl( AsyncCallback<String> callback);

  void getPicture(String id, AsyncCallback<PatientInfo> callback);

void storePatienceInfo(PatientInfo patientInfo,
		AsyncCallback<PatientInfo> asyncCallback);







}