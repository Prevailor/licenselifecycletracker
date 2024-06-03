package com.training.licenselifecycletracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
import com.training.licenselifecycletracker.service.NotificationService;
import com.training.licenselifecycletracker.service.ReportService;
import com.training.licenselifecycletracker.service.SoftwareService;
import com.training.licenselifecycletracker.service.UserService;


@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private DeviceService deviceService;
    
    @Autowired
    private SoftwareService softwareService;
    
    @Autowired
    private LifecycleeventService lifecycleeventService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private ReportService reportService;
    
    @Autowired
    NotificationService notificationService;
	

    // Create Devices
    
    @PostMapping("/addDevices")
    
    public ResponseEntity<Device> addDevice(@RequestBody Device device) {
        Device devices = deviceService.addDevice(device);
        return ResponseEntity.ok(devices);
    }
    
//    @GetMapping("/devices")
//    public ResponseEntity<?> viewDevices() {
//    	
//        try {
//            List<Device> devices = (List<Device>) deviceService.viewDevices().getBody();
//            return ResponseEntity.ok(devices);
//        }catch(DeviceNotFoundException e) {
//          return null;	
//        }
//        
//    }
//    
////    //Update Device
////    
//    @PutMapping("/updateDevices")
//    public Device updateDevice(@RequestBody Device device) throws DeviceNotFoundException {
//    	return deviceService.updateDevice(device);
//        
//    }
//    
//    //delete device
//    
//    @PostMapping("deletedevice")
//    public ResponseEntity<String> deleteDeviceById(@PathVariable Integer deviceId) throws DeviceNotFoundException {
//        String result = deviceService.deleteDeviceById(deviceId);
//        if (result != null) {
//            return ResponseEntity.ok(result);
//        } else {
//            return null;
//        }
//    }
//    
    
    @GetMapping("/getalldevices")
    public ResponseEntity<?> viewDevices() {
        try {
            List<Device> devices = (List<Device>) deviceService.viewDevices().getBody();
            return ResponseEntity.ok(devices);
        } catch (DeviceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // Update Device
    @PutMapping("/updateDevices")
    public ResponseEntity<?> updateDevice(@RequestBody Device device) {
        try {
            Device updatedDevice = deviceService.updateDevice(device);
            return ResponseEntity.ok(updatedDevice);
        } catch (DeviceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // Delete device
    @PostMapping("/deletedevice/{deviceId}")
    public ResponseEntity<?> deleteDeviceById(@PathVariable Integer deviceId) {
        try {
            String result = deviceService.deleteDeviceById(deviceId);
            return ResponseEntity.ok(result);
        } catch (DeviceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    
   
    
    // Create Software
    
//    @PostMapping("/addsoftwares")
//    
//    public ResponseEntity<Software> addSoftware(@RequestBody Software software) {
//        Software softwares = softwareService.addSoftware(software);
//        return ResponseEntity.ok(softwares);
//    }
//
//     //Update Software
//
//      @PutMapping("/updateSoftware")
//      public Software updateSoftware(@RequestBody Software software) throws SoftwareNotFoundException {
//	    return softwareService.updateSoftware(software);
//    
//      }
//      
//      // delete software
//      
//      @PostMapping("delete/software/{softwareId}")
//      public ResponseEntity<String> deleteSoftwareById(@PathVariable Integer softwareId) throws SoftwareNotFoundException {
//          String result = softwareService.deleteSoftwareById(softwareId);
//          if (result != null) {
//              return ResponseEntity.ok(result);
//          } else {
//              return ResponseEntity.notFound().build();
//          }
//      }
//   
//    
    
    @PostMapping("/addSoftware")
    public ResponseEntity<Software> addSoftware(@RequestBody Software software) {
        Software savedSoftware = softwareService.addSoftware(software);
        return ResponseEntity.ok(savedSoftware);
    }

    @PutMapping("/updatesoftware")
    public ResponseEntity<Software> updateSoftware(@RequestBody Software software) {
        try {
            Software updatedSoftware = softwareService.updateSoftware(software);
            return ResponseEntity.ok(updatedSoftware);
        } catch (SoftwareNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/deletesoftware/{softwareId}")
    public ResponseEntity<String> deleteSoftwareById(@PathVariable Integer softwareId) {
        try {
            String result = softwareService.deleteSoftwareById(softwareId);
            return ResponseEntity.ok(result);
        } catch (SoftwareNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    

      
   // Create LifecycleEvent
//      
//      @PostMapping("/addLifecycleEvent")
//      
//      public ResponseEntity<LifecycleEvent> addLifecycleEvent(@RequestBody LifecycleEvent lifecycleevent) {
//    	  LifecycleEvent lifecycleevents = lifecycleeventService.addLifeCycleEvent(lifecycleevent);
//          return ResponseEntity.ok(lifecycleevents);
//      }
//      
//      
//      // delete life cycle event
//      @PostMapping("/deleteLifeCycleEvent/{eventId}")
//      public ResponseEntity<String> deleteLifeCycleEventById(@PathVariable Integer eventId) throws LifecycleEventNotFoundException {
//          String result = lifecycleeventService.deleteLifeCycleEventById(eventId);
//          if (result != null) {
//              return ResponseEntity.ok(result);
//          } else {
//              return null;
//          }
//   }
//   
    
    @PostMapping("/addlifecycleevent")
    public ResponseEntity<LifecycleEvent> addLifecycleEvent(@RequestBody LifecycleEvent lifecycleEvent) {
        LifecycleEvent savedEvent = lifecycleeventService.addLifeCycleEvent(lifecycleEvent);
        return ResponseEntity.ok(savedEvent);
    }

    @PostMapping("/deletelifecyclevent/{eventId}")
    public ResponseEntity<String> deleteLifecycleEventById(@PathVariable Integer eventId) {
        try {
            String result = lifecycleeventService.deleteLifeCycleEventById(eventId);
            return ResponseEntity.ok(result);
        } catch (LifecycleEventNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
      
      
      
      // user
      
      
//      @PostMapping("/add")
//      public ResponseEntity<User> addUser(@RequestBody User user) throws UserNotFoundException {
//          User addedUser = userService.addUser(user);
//          return ResponseEntity.ok(addedUser);
//      }
//
//      @GetMapping("getuserbyid")
//      public ResponseEntity<User> getUserById(@PathVariable Integer userId) throws UserNotFoundException {
//          User user = userService.getUserById(userId);
//          if (user != null) {
//              return ResponseEntity.ok(user);
//          } else {
//              return null;
//          }
//      }
//
//      @PostMapping("deleteuser")
//      public ResponseEntity<String> deleteUserById(@PathVariable Integer userId) throws UserNotFoundException {
//          String result = userService.deleteUserById(userId);
//          if (result != null) {
//              return ResponseEntity.ok(result);
//          } else {
//              return null;
//          }
//      }
//
//      @PutMapping("/update")
//      public ResponseEntity<User> updateUser(@RequestBody User user) throws UserNotFoundException {
//          User updatedUser = userService.updateUser(user);
//          if (updatedUser != null) {
//              return ResponseEntity.ok(updatedUser);
//          } else {
//              return null;
//          }
//      }
//   
//    
    
    @PostMapping("/adduser")
      public ResponseEntity<User> addUser(@RequestBody User user) throws UserNotFoundException {
      User addedUser = userService.addUser(user);
      return ResponseEntity.ok(addedUser);
      }
    @GetMapping("/get/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Integer userId) {
        try {
            User user = userService.getUserById(userId);
            return ResponseEntity.ok(user);
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/deleteuser/{userId}")
    public ResponseEntity<String> deleteUserById(@PathVariable Integer userId) {
        try {
            String result = userService.deleteUserById(userId);
            return ResponseEntity.ok(result);
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updateuser")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        try {
            User updatedUser = userService.updateUser(user);
            return ResponseEntity.ok(updatedUser);
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    @GetMapping("/devicesreport")
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
    
    
    
    
    // notifications
    
   

//    @PostMapping("/sendGeneralNotification")
//    public void sendGeneralNotification(@RequestBody String message) {
//        notificationService.sendGeneralNotification(message);
//    }
    
    
    @PostMapping("/sendGeneralNotification")
    public ResponseEntity<String> sendGeneralNotification(@RequestBody String message) {
        notificationService.sendGeneralNotification(message);
        return ResponseEntity.ok("Notification sent successfully");
    }
    
}
