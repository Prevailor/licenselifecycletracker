package com.training.licenselifecycletracker.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.training.licenselifecycletracker.entities.Device;

@Repository
public interface DeviceRepository extends CrudRepository<Device, Integer> {
	
	public Device findByDeviceName(String deviceName);
	public List<Device> findByStatus(String status);
	public List<Device> findByDeviceType(String deviceType);
	public List<Device> findByPurchaseDate(Date purchaseDate);
	public List<Device> findByExpirationDate(Date expirationDate);
	public List<Device> findByEndOfSupportDate(Date endOfSupportDate);
}
