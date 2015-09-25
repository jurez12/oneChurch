package com.onechurchOld.client;


import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.onechurch.shared.PatientInfo;



@RemoteServiceRelativePath("healthservice")
public interface OneChurchService extends RemoteService {



  PatientInfo getPicture(String id);

PatientInfo storePatienceInfo(PatientInfo patientInfo);

String getBlobStoreUploadUrl();

}
