package com.training.licenselifecycletracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.licenselifecycletracker.entities.Device;
import com.training.licenselifecycletracker.entities.LifecycleEvent;
import com.training.licenselifecycletracker.entities.Software;
import com.training.licenselifecycletracker.exceptions.DeviceNotFoundException;
import com.training.licenselifecycletracker.exceptions.SoftwareNotFoundException;
import com.training.licenselifecycletracker.service.DeviceService;
import com.training.licenselifecycletracker.service.LifecycleeventService;
import com.training.licenselifecycletracker.service.ReportService;
import com.training.licenselifecycletracker.service.SoftwareService;

@RestController
@RequestMapping("/api/management")
public class ManagementController {
	
	
	@Autowired
    private LifecycleeventService lifecycleeventService;
	
	@Autowired
    private ReportService reportService;
	
	@Autowired
    private DeviceService deviceService;
	
	@Autowired
    private SoftwareService softwareService;
	
	
	 // Endpoints for Management actions
	
	
//	 @GetMapping("/management/lifecycle/{relatedId}")
//	 
//	    public ResponseEntity<?> viewLifecycleEvents() {
//	       
//	            List<LifecycleEvent> lifecycleevents = (List<LifecycleEvent>) lifecycleeventService.viewLifecycleEvents().getBody();
//	            return ResponseEntity.ok(lifecycleevents);
//	        
//	    }
//	
//	 @GetMapping("/management/reports/{assetId}")
//	 public void generateLifecycleReports(@PathVariable int assetId) {
//	     // Call corresponding service method
//	 }
	
	@GetMapping("/management/lifecycle/{relatedId}")
    public ResponseEntity<?> viewLifecycleEvents(@PathVariable int relatedId) {
        try {
            List<LifecycleEvent> lifecycleevents = (List<LifecycleEvent>) lifecycleeventService.viewLifecycleEvents().getBody();
            return ResponseEntity.ok(lifecycleevents);
        } catch (Exception e) {
            // Handle other exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

//    @GetMapping("/management/reports/{assetId}")
//    public ResponseEntity<?> generateLifecycleReports(@PathVariable int assetId) {
//        try {
//            // Call corresponding service method
//            // Assuming you will return some response after generating reports
//            return ResponseEntity.ok("Lifecycle reports generated successfully for asset ID: " + assetId);
//        } catch (Exception e) {
//            // Handle other exceptions
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        }
//    }
	
	@GetMapping("/management/devicesreport")
	public ResponseEntity<String> generateDeviceReport() {
	    try {
	        ResponseEntity<List<Device>> responseEntity = deviceService.viewDevices();
	        List<Device> devices = responseEntity.getBody();
	        if (devices.isEmpty()) {
	            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No devices found.");
	        }
	        String deviceReport = reportService.generateDeviceReport(devices);
	        return ResponseEntity.ok(deviceReport);
	    } catch (DeviceNotFoundException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No devices found.");
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error generating device report.");
	    }
	}

	@GetMapping("/softwarereport")
	public ResponseEntity<String> generateSoftwareReport() {
	    try {
	        ResponseEntity<List<Software>> responseEntity = softwareService.viewSoftwares();
	        List<Software> softwareList = responseEntity.getBody();
	        if (softwareList.isEmpty()) {
	            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No software found.");
	        }
	        String softwareReport = reportService.generateSoftwareReport(softwareList);
	        return ResponseEntity.ok(softwareReport);
	    } catch (SoftwareNotFoundException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No software found.");
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error generating software report.");
	    }
	}

}