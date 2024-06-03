package com.training.licenselifecycletracker.service;


import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.training.licenselifecycletracker.entities.Software;
import com.training.licenselifecycletracker.exceptions.SoftwareNotFoundException;

public interface SoftwareService {
	
	//Create
		public Software addSoftware(Software software);
		//Retrieve
		public Software getSoftwareById(Integer softwareId) throws SoftwareNotFoundException;
		
		public Software getSoftwareByName(String softwareName)throws SoftwareNotFoundException;
		
		public List<Software> getSoftwareByStatus(String status)throws SoftwareNotFoundException;
		
		public List<Software> getSoftwareByLicenseKey(String licenseKey)throws SoftwareNotFoundException;
		
		public List<Software> getSoftwareByPurchaseDate(Date purchaseDate)throws SoftwareNotFoundException;
		
		public List<Software> getSoftwareByExpirationDate(Date expirationDate)throws SoftwareNotFoundException;
		
		public List<Software> getSoftwareBySupportEndDate(Date supportEndDate)throws SoftwareNotFoundException;
		
		public ResponseEntity<List<Software>> viewSoftwares()throws SoftwareNotFoundException;

		
		//Delete
		public String deleteSoftwareById(Integer softwareId)throws SoftwareNotFoundException;
		
		//Update
		public Software updateSoftware(Software software)throws SoftwareNotFoundException;
		
		//notifications
		
		public void receiveNotifications();
		
}
