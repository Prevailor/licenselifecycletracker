package com.training.licenselifecycletracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/technicalsupport")
public class TechnicalSupportController {

	 // Endpoints for Technical Support actions
	 @PostMapping("/support/faults")
	 public void logFault(@RequestParam int deviceId, @RequestParam String description, @RequestParam String date) {
	     // Call corresponding service method
	 }

	 @PutMapping("/support/faults/{deviceId}")
	 public void updateFaultLog(@PathVariable int deviceId, @RequestParam String repairDetails) {
	     // Call corresponding service method
	 }

	 @GetMapping("/support/dates")
	 public void viewSupportDates() {
	     // Call corresponding service method
	 }

}