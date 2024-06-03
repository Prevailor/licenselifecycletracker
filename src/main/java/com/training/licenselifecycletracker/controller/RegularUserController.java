package com.training.licenselifecycletracker.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.licenselifecycletracker.entities.Device;
import com.training.licenselifecycletracker.entities.LifecycleEvent;
import com.training.licenselifecycletracker.entities.Software;
import com.training.licenselifecycletracker.entities.User;
import com.training.licenselifecycletracker.exceptions.DeviceNotFoundException;
import com.training.licenselifecycletracker.exceptions.LifecycleEventNotFoundException;
import com.training.licenselifecycletracker.exceptions.SoftwareNotFoundException;
import com.training.licenselifecycletracker.exceptions.UserNotFoundException;
import com.training.licenselifecycletracker.service.DeviceService;
import com.training.licenselifecycletracker.service.LifecycleeventService;
import com.training.licenselifecycletracker.service.SoftwareService;
import com.training.licenselifecycletracker.service.UserService;

@RestController
@RequestMapping("/api/regularuser")
public class RegularUserController {
	
	@Autowired
    private DeviceService deviceService;
	
	@Autowired
    private SoftwareService softwareService;
	
	@Autowired
    private LifecycleeventService lifecycleeventService;
	
	@Autowired
    private UserService userService;
	
	
	// Retrieve for Device
	
	
//	@GetMapping("/getalldevices")
//    public ResponseEntity<?> viewDevices() throws DeviceNotFoundException {
//       
//            List<Device> devices = (List<Device>) deviceService.viewDevices().getBody();
//            return ResponseEntity.ok(devices);
//        
//    }
//	
//	@GetMapping("/getdevice")
//	public Device getDevice(@RequestParam("id") Integer deviceId) throws DeviceNotFoundException  {
//		return  deviceService.getDeviceById(deviceId);
//		
//	}
//	
//	
//	@GetMapping("/getdevicebyname")
//	public ResponseEntity<Device> getMovieByName(@RequestParam("mname") String deviceName) throws DeviceNotFoundException{
//		Device device = deviceService.getDeviceByName(deviceName);
//		return new ResponseEntity<>(device, HttpStatus.FOUND);
//	}
//	
//
//	
//	@GetMapping("/getdevicesbystatus")
//	public ResponseEntity<List<Device>> getDevicesByStatus(@RequestParam("status") String status) throws DeviceNotFoundException {
//	    List<Device> devices = deviceService.getDeviceByStatus(status);
//	    if (devices != null && !devices.isEmpty()) {
//	        return new ResponseEntity<>(devices, HttpStatus.OK);
//	    } else {
//	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	    }
//	}
//	
//	@GetMapping("/getdevicesbydevicetype")
//	public ResponseEntity<List<Device>> getDevicesByDeviceType(@RequestParam("deviceType") String deviceType) throws DeviceNotFoundException {
//	    List<Device> devices = deviceService.getDeviceByDeviceType(deviceType);
//	    if (devices != null && !devices.isEmpty()) {
//	        return new ResponseEntity<>(devices, HttpStatus.OK);
//	    } else {
//	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	    }
//	}
//	
//	@GetMapping("/getdevicesbypurchasedate")
//	public ResponseEntity<List<Device>> getDevicesByPurchaseDate(@RequestParam("purchaseDate") Date purchaseDate) throws DeviceNotFoundException {
//	    List<Device> devices = deviceService.getDeviceByPurchaseDate(purchaseDate);
//	    if (devices != null && !devices.isEmpty()) {
//	        return new ResponseEntity<>(devices, HttpStatus.OK);
//	    } else {
//	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	    }
//	}
//	
//	@GetMapping("/getdevicesbyexpirationdate")
//	public ResponseEntity<List<Device>> getDevicesByExpirationDate(@RequestParam("expirationDate") Date expirationDate) throws DeviceNotFoundException {
//	    List<Device> devices = deviceService.getDeviceByExpirationDate(expirationDate);
//	    if (devices != null && !devices.isEmpty()) {
//	        return new ResponseEntity<>(devices, HttpStatus.OK);
//	    } else {
//	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	    }
//	}
//	
//	@GetMapping("/getdevicesbyendofsupportdate")
//	public ResponseEntity<List<Device>> getDevicesByEndOfSupportDate(@RequestParam("endOfSupportDate") Date endOfSupportDate) throws DeviceNotFoundException {
//	    List<Device> devices = deviceService.getDeviceByEndOfSupportDate(endOfSupportDate);
//	    if (devices != null && !devices.isEmpty()) {
//	        return new ResponseEntity<>(devices, HttpStatus.OK);
//	    } else {
//	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	    }
//	}
	
	@GetMapping("/getalldevices")
	public ResponseEntity<?> viewDevices() {
	    try {
	        List<Device> devices = (List<Device>) deviceService.viewDevices().getBody();
	        return ResponseEntity.ok(devices);
	    } catch (DeviceNotFoundException ex) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	    }
	}

	@GetMapping("/getdevice")
	public ResponseEntity<?> getDevice(@RequestParam("id") Integer deviceId) {
	    try {
	        Device device = deviceService.getDeviceById(deviceId);
	        return ResponseEntity.ok(device);
	    } catch (DeviceNotFoundException ex) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	    }
	}

	@GetMapping("/getdevicebyname")
	public ResponseEntity<?> getDeviceByName(@RequestParam("mname") String deviceName) {
	    try {
	        Device device = deviceService.getDeviceByName(deviceName);
	        return ResponseEntity.ok(device);
	    } catch (DeviceNotFoundException ex) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	    }
	}

	@GetMapping("/getdevicesbystatus")
	public ResponseEntity<?> getDevicesByStatus(@RequestParam("status") String status) {
	    try {
	        List<Device> devices = deviceService.getDeviceByStatus(status);
	        return ResponseEntity.ok(devices);
	    } catch (DeviceNotFoundException ex) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	    }
	}

	@GetMapping("/getdevicesbydevicetype")
	public ResponseEntity<?> getDevicesByDeviceType(@RequestParam("deviceType") String deviceType) {
	    try {
	        List<Device> devices = deviceService.getDeviceByDeviceType(deviceType);
	        return ResponseEntity.ok(devices);
	    } catch (DeviceNotFoundException ex) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	    }
	}

	@GetMapping("/getdevicesbypurchasedate")
	public ResponseEntity<?> getDevicesByPurchaseDate(@RequestParam("purchaseDate") Date purchaseDate) {
	    try {
	        List<Device> devices = deviceService.getDeviceByPurchaseDate(purchaseDate);
	        return ResponseEntity.ok(devices);
	    } catch (DeviceNotFoundException ex) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	    }
	}

	@GetMapping("/getdevicesbyexpirationdate")
	public ResponseEntity<?> getDevicesByExpirationDate(@RequestParam("expirationDate") Date expirationDate) {
	    try {
	        List<Device> devices = deviceService.getDeviceByExpirationDate(expirationDate);
	        return ResponseEntity.ok(devices);
	    } catch (DeviceNotFoundException ex) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	    }
	}

	@GetMapping("/getdevicesbyendofsupportdate")
	public ResponseEntity<?> getDevicesByEndOfSupportDate(@RequestParam("endOfSupportDate") Date endOfSupportDate) {
	    try {
	        List<Device> devices = deviceService.getDeviceByEndOfSupportDate(endOfSupportDate);
	        return ResponseEntity.ok(devices);
	    } catch (DeviceNotFoundException ex) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	    }
	}
	// Retrieve for Software
	
	
//	@GetMapping("/getallsoftwares")
//    public ResponseEntity<?> viewSoftwares() throws SoftwareNotFoundException {
//       
//            List<Software> softwares = (List<Software>) softwareService.viewSoftwares().getBody();
//            return ResponseEntity.ok(softwares);
//        
//    }
//	
//	@GetMapping("/getsoftware")
//	public Software getSoftware(@RequestParam("id") Integer softwareId) throws SoftwareNotFoundException  {
//		return  softwareService.getSoftwareById(softwareId);
//		
//	}
//	
//	@GetMapping("/getsoftwarebyname")
//	public ResponseEntity<Software> getSoftwareByName(@RequestParam("mname") String softwareName) throws SoftwareNotFoundException{
//		Software software = softwareService.getSoftwareByName(softwareName);
//		return new ResponseEntity<>(software, HttpStatus.FOUND);
//	}
//	
//	@GetMapping("/getsoftwarebystatus")
//	public ResponseEntity<List<Software>> getSoftwareByStatus(@RequestParam("status") String status) throws SoftwareNotFoundException {
//	    List<Software> softwares = softwareService.getSoftwareByStatus(status);
//	    if (softwares != null && !softwares.isEmpty()) {
//	        return new ResponseEntity<>(softwares, HttpStatus.OK);
//	    } else {
//	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	    }
//	}
//	
//	@GetMapping("/getsoftwarebylicensekey")
//	public ResponseEntity<List<Software>> getSoftwareByLicenseKey(@RequestParam("licenseKey") String licenseKey) throws SoftwareNotFoundException {
//	    List<Software> software = softwareService.getSoftwareByLicenseKey(licenseKey);
//	    if (software != null && !software.isEmpty()) {
//	        return new ResponseEntity<>(software, HttpStatus.OK);
//	    } else {
//	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	    }
//	}
//	
//	@GetMapping("/getsoftwarebypurchasedate")
//	public ResponseEntity<List<Software>> getSoftwareByPurchaseDate(@RequestParam("purchaseDate") Date purchaseDate) throws SoftwareNotFoundException {
//	    List<Software> software = softwareService.getSoftwareByPurchaseDate(purchaseDate);
//	    if (software != null && !software.isEmpty()) {
//	        return new ResponseEntity<>(software, HttpStatus.OK);
//	    } else {
//	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	    }
//	}
//	
//	@GetMapping("/getsoftwarebyexpirationdate")
//	public ResponseEntity<List<Software>> getSoftwareByExpirationDate(@RequestParam("expirationDate") Date expirationDate) throws SoftwareNotFoundException {
//	    List<Software> software = softwareService.getSoftwareByExpirationDate(expirationDate);
//	    if (software != null && !software.isEmpty()) {
//	        return new ResponseEntity<>(software, HttpStatus.OK);
//	    } else {
//	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	    }
//	}
//	
//	@GetMapping("/getsoftwarebyendofsupportdate")
//	public ResponseEntity<List<Software>> getSoftwareByEndOfSupportDate(@RequestParam("supportEndDate") Date supportEndDate) throws SoftwareNotFoundException {
//	    List<Software> software = softwareService.getSoftwareBySupportEndDate(supportEndDate);
//	    if (software!= null && !software.isEmpty()) {
//	        return new ResponseEntity<>(software, HttpStatus.OK);
//	    } else {
//	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	    }
//	}
//	
	
    

        // Retrieve for Software

	@GetMapping("/getallsoftwares")
	public ResponseEntity<?> viewSoftwares() {
	    try {
	        List<Software> softwares = (List<Software>) softwareService.viewSoftwares().getBody();
	        return ResponseEntity.ok(softwares);
	    } catch (SoftwareNotFoundException ex) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	    }
	}

	@GetMapping("/getsoftware")
	public ResponseEntity<?> getSoftware(@RequestParam("id") Integer softwareId) {
	    try {
	        Software software = softwareService.getSoftwareById(softwareId);
	        return ResponseEntity.ok(software);
	    } catch (SoftwareNotFoundException ex) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	    }
	}

	@GetMapping("/getsoftwarebyname")
	public ResponseEntity<?> getSoftwareByName(@RequestParam("mname") String softwareName) {
	    try {
	        Software software = softwareService.getSoftwareByName(softwareName);
	        return ResponseEntity.ok(software);
	    } catch (SoftwareNotFoundException ex) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	    }
	}

	@GetMapping("/getsoftwarebystatus")
	public ResponseEntity<?> getSoftwareByStatus(@RequestParam("status") String status) {
	    try {
	        List<Software> softwares = softwareService.getSoftwareByStatus(status);
	        if (!softwares.isEmpty()) {
	            return ResponseEntity.ok(softwares);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    } catch (SoftwareNotFoundException ex) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	    }
	}

	@GetMapping("/getsoftwarebylicensekey")
	public ResponseEntity<?> getSoftwareByLicenseKey(@RequestParam("licenseKey") String licenseKey) {
	    try {
	        List<Software> software = softwareService.getSoftwareByLicenseKey(licenseKey);
	        if (!software.isEmpty()) {
	            return ResponseEntity.ok(software);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    } catch (SoftwareNotFoundException ex) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	    }
	}

	@GetMapping("/getsoftwarebypurchasedate")
	public ResponseEntity<?> getSoftwareByPurchaseDate(@RequestParam("purchaseDate") Date purchaseDate) {
	    try {
	        List<Software> software = softwareService.getSoftwareByPurchaseDate(purchaseDate);
	        if (!software.isEmpty()) {
	            return ResponseEntity.ok(software);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    } catch (SoftwareNotFoundException ex) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	    }
	}

	@GetMapping("/getsoftwarebyexpirationdate")
	public ResponseEntity<?> getSoftwareByExpirationDate(@RequestParam("expirationDate") Date expirationDate) {
	    try {
	        List<Software> software = softwareService.getSoftwareByExpirationDate(expirationDate);
	        if (!software.isEmpty()) {
	            return ResponseEntity.ok(software);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    } catch (SoftwareNotFoundException ex) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	    }
	}

	@GetMapping("/getsoftwarebyendofsupportdate")
	public ResponseEntity<?> getSoftwareByEndOfSupportDate(@RequestParam("supportEndDate") Date supportEndDate) {
	    try {
	        List<Software> software = softwareService.getSoftwareBySupportEndDate(supportEndDate);
	        if (!software.isEmpty()) {
	            return ResponseEntity.ok(software);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    } catch (SoftwareNotFoundException ex) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	    }
	}

	//Retriev for LifeCycleEvent
	
//	//Retriev for LifeCycleEvent
//	
//		@GetMapping("/getlifecycleevent")
//		public LifecycleEvent getLifeCycleEvent(@RequestParam("id") Integer eventId)  {
//			return  lifecycleeventService.getLifeCycleEventById(eventId);
//			
//		}
//		
//		@GetMapping("/getLifeCycleEventByEventType")
//	    public ResponseEntity<List<LifecycleEvent>> getLifeCycleEventByEventType(@RequestParam String eventType) {
//	        List<LifecycleEvent> events = lifecycleeventService.getLifeCycleEventByEventType(eventType);
//	        if (events != null && !events.isEmpty()) {
//	            return ResponseEntity.ok(events);
//	        } else {
//	            return ResponseEntity.notFound().build();
//	        }
//	    }
//		
//		@GetMapping("/getLifeCycleEventByEventDate")
//	    public ResponseEntity<List<LifecycleEvent>> getLifeCycleEventByEventDate(@RequestParam Date eventDate) {
//	        List<LifecycleEvent> events = lifecycleeventService.getLifeCycleEventByEventDate(eventDate);
//	        if (events != null && !events.isEmpty()) {
//	            return ResponseEntity.ok(events);
//	        } else {
//	            return ResponseEntity.notFound().build();
//	        }
//	    }
//
//	    @GetMapping("/getLifeCycleEventByDescription")
//	    public ResponseEntity<List<LifecycleEvent>> getLifeCycleEventByDescription(@RequestParam String description) {
//	        List<LifecycleEvent> events = lifecycleeventService.getLifeCycleEventByDescription(description);
//	        if (events != null && !events.isEmpty()) {
//	            return ResponseEntity.ok(events);
//	        } else {
//	            return ResponseEntity.notFound().build();
//	        }
//	    }
//	    
//	    @GetMapping("/getLifeCycleEventByCategory")
//	    public ResponseEntity<List<LifecycleEvent>> getLifeCycleEventByCategory(@RequestParam String category) {
//	        List<LifecycleEvent> events = lifecycleeventService.getLifeCycleEventByCategory(category);
//	        if (events != null && !events.isEmpty()) {
//	            return ResponseEntity.ok(events);
//	        } else {
//	            return ResponseEntity.notFound().build();
//	        }
//	    }

	@GetMapping("/getlifecycleevent")
	public ResponseEntity<?> getLifeCycleEvent(@RequestParam("id") Integer eventId) {
	    try {
	        LifecycleEvent event = lifecycleeventService.getLifeCycleEventById(eventId);
	        return ResponseEntity.ok(event);
	    } catch (LifecycleEventNotFoundException ex) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	    }
	}

	@GetMapping("/getLifeCycleEventByEventType")
	public ResponseEntity<?> getLifeCycleEventByEventType(@RequestParam String eventType) {
	    try {
	        List<LifecycleEvent> events = lifecycleeventService.getLifeCycleEventByEventType(eventType);
	        return events.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(events);
	    } catch (LifecycleEventNotFoundException ex) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	    }
	}

	@GetMapping("/getLifeCycleEventByEventDate")
	public ResponseEntity<?> getLifeCycleEventByEventDate(@RequestParam Date eventDate) {
	    try {
	        List<LifecycleEvent> events = lifecycleeventService.getLifeCycleEventByEventDate(eventDate);
	        return events.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(events);
	    } catch (LifecycleEventNotFoundException ex) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	    }
	}

	@GetMapping("/getLifeCycleEventByDescription")
	public ResponseEntity<?> getLifeCycleEventByDescription(@RequestParam String description) {
	    try {
	        List<LifecycleEvent> events = lifecycleeventService.getLifeCycleEventByDescription(description);
	        return events.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(events);
	    } catch (LifecycleEventNotFoundException ex) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	    }
	}

	@GetMapping("/getLifeCycleEventByCategory")
	public ResponseEntity<?> getLifeCycleEventByCategory(@RequestParam String category) {
	    try {
	        List<LifecycleEvent> events = lifecycleeventService.getLifeCycleEventByCategory(category);
	        return events.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(events);
	    } catch (LifecycleEventNotFoundException ex) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	    }
	}
	
	
    //  user
    
//    @GetMapping("getuserbyid")
//    public ResponseEntity<User> getUserById(@PathVariable Integer userId) throws UserNotFoundException {
//        User user = userService.getUserById(userId);
//        if (user != null) {
//            return ResponseEntity.ok(user);
//        } else {
//            return null;
//        }
//    }
	
	
	
    
    @GetMapping("/getuserbyid")
    public ResponseEntity<?> getUserById(@PathVariable Integer userId) {
        try {
            User user = userService.getUserById(userId);
            return ResponseEntity.ok(user);
        } catch (UserNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
    
    



    // notifications

//	@GetMapping("/notifications")
//	public void receiveNotifications() {
//	    // Call corresponding service method
//	    softwareService.receiveNotifications();
//	}
		
		
}
	

