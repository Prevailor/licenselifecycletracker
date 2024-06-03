package com.training.licenselifecycletracker.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.training.licenselifecycletracker.entities.Device;
import com.training.licenselifecycletracker.exceptions.DeviceNotFoundException;
import com.training.licenselifecycletracker.repositories.DeviceRepository;

//@Service
//public class DeviceServiceImpl implements DeviceService{
//	
//	@Autowired
//    DeviceRepository repo;
//
//	@Override
//	public Device addDevice(Device device) {
//		return repo.save(device);
//	}
//
//	@Override
//    public ResponseEntity<List<Device>> viewDevices() throws DeviceNotFoundException  {
//        List<Device> devices = (List<Device>) repo.findAll();
//        if (devices.isEmpty()) {
//        	throw new  DeviceNotFoundException("No Devices Found");
//        }
//        return ResponseEntity.ok(devices);
//    }
//
//	
//	@Override
//	public Device getDeviceById(Integer deviceId) {
//         Optional<Device> device = repo.findById(deviceId);
//			if(device.isPresent()) {
//				
//				return device.get();
//			}else {
//			     return null;
//			}
//		
//	}
//
//
//	public Device getDeviceByName(String deviceName)  {
//		Device device= repo.findByDeviceName(deviceName);
//		if(device != null) {		
//			return device;
//		}else {
//			
//			return null;
//		}
//	}
//
//	public List<Device> getDeviceByStatus(String status) {
//        List<Device> device = (List<Device>) repo.findByStatus(status);
//        if(device.isEmpty()) {
//        	return null;
//        }
//        return device;
//    }
//	
//	@Override
//	public Device updateDevice(Device device) {
//		Optional<Device> devices = repo.findById(device.getDeviceId());
//		if (devices.isPresent()) {
//			return repo.save(device);
//		} else {
//			return null;
//		}
//	}
//
//	
//
//	@Override
//	public String deleteDeviceById(Integer deviceId) {
//		Optional<Device> person = repo.findById(deviceId);
//		if (person.isPresent()) {
//			repo.deleteById(deviceId);
//			return "Device with Id " + deviceId + " deleted successfully";
//		} else {
//			return "Device with DeviceId " + deviceId + " doesn't exists";
//		}
//	}
//
//	@Override
//	public List<Device> getDeviceByDeviceType(String deviceType) {
//		 List<Device> device = (List<Device>) repo.findByDeviceType(deviceType);
//	        if(device.isEmpty()) {
//	        	return null;
//	        }
//	        return device;
//		
//	}
//
//	@Override
//	public List<Device> getDeviceByPurchaseDate(Date purchaseDate) {
//		List<Device> device = (List<Device>) repo.findByPurchaseDate(purchaseDate);
//        if(device.isEmpty()) {
//        	return null;
//        }
//        return device;
//	}
//
//	@Override
//	public List<Device> getDeviceByExpirationDate(Date expirationDate) {
//		List<Device> device = (List<Device>) repo.findByExpirationDate(expirationDate);
//        if(device.isEmpty()) {
//        	return null;
//        }
//        return device;
//	}
//
//	@Override
//	public List<Device> getDeviceByEndOfSupportDate(Date endOfSupportDate) {
//		List<Device> device = (List<Device>) repo.findByEndOfSupportDate(endOfSupportDate);
//        if(device.isEmpty()) {
//        	return null;
//        }
//        return device;
//	}
//		
//	
//	
//	
//}


@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    DeviceRepository repo;

    @Override
    public Device addDevice(Device device) {
        return repo.save(device);
    }

    @Override
    public ResponseEntity<List<Device>> viewDevices() throws DeviceNotFoundException {
        List<Device> devices = (List<Device>) repo.findAll();
        if (devices.isEmpty()) {
            throw new DeviceNotFoundException("No Devices Found");
        }
        return ResponseEntity.ok(devices);
    }

    @Override
    public Device getDeviceById(Integer deviceId) throws DeviceNotFoundException {
        Optional<Device> device = repo.findById(deviceId);
        if (device.isPresent()) {
            return device.get();
        } else {
            throw new DeviceNotFoundException("Device with Id " + deviceId + " not found");
        }
    }

    public Device getDeviceByName(String deviceName) throws DeviceNotFoundException {
        Device device = repo.findByDeviceName(deviceName);
        if (device != null) {
            return device;
        } else {
            throw new DeviceNotFoundException("Device with name " + deviceName + " not found");
        }
    }

    // Add similar exception handling for other methods...

    @Override
    public List<Device> getDeviceByDeviceType(String deviceType) throws DeviceNotFoundException {
        List<Device> device = (List<Device>) repo.findByDeviceType(deviceType);
        if (device.isEmpty()) {
            throw new DeviceNotFoundException("No devices found with device type: " + deviceType);
        }
        return device;
    }
    
    @Override
    public List<Device> getDeviceByStatus(String status) throws DeviceNotFoundException {
        List<Device> devices = (List<Device>) repo.findByStatus(status);
        if (devices.isEmpty()) {
            throw new DeviceNotFoundException("No devices found with status: " + status);
        }
        return devices;
    }

    @Override
    public Device updateDevice(Device device) throws DeviceNotFoundException {
        Optional<Device> devices = repo.findById(device.getDeviceId());
        if (devices.isPresent()) {
            return repo.save(device);
        } else {
            throw new DeviceNotFoundException("Device with Id " + device.getDeviceId() + " not found");
        }
    }

    @Override
    public String deleteDeviceById(Integer deviceId) throws DeviceNotFoundException {
        Optional<Device> device = repo.findById(deviceId);
        if (device.isPresent()) {
            repo.deleteById(deviceId);
            return "Device with Id " + deviceId + " deleted successfully";
        } else {
            throw new DeviceNotFoundException("Device with Id " + deviceId + " not found");
        }
    }

    @Override
    public List<Device> getDeviceByPurchaseDate(Date purchaseDate) throws DeviceNotFoundException {
        List<Device> device = (List<Device>) repo.findByPurchaseDate(purchaseDate);
        if (device.isEmpty()) {
            throw new DeviceNotFoundException("No devices found with purchase date: " + purchaseDate);
        }
        return device;
    }

    @Override
    public List<Device> getDeviceByExpirationDate(Date expirationDate) throws DeviceNotFoundException {
        List<Device> device = (List<Device>) repo.findByExpirationDate(expirationDate);
        if (device.isEmpty()) {
            throw new DeviceNotFoundException("No devices found with expiration date: " + expirationDate);
        }
        return device;
    }

    @Override
    public List<Device> getDeviceByEndOfSupportDate(Date endOfSupportDate) throws DeviceNotFoundException {
        List<Device> device = (List<Device>) repo.findByEndOfSupportDate(endOfSupportDate);
        if (device.isEmpty()) {
            throw new DeviceNotFoundException("No devices found with end of support date: " + endOfSupportDate);
        }
        return device;
    }

	
}
