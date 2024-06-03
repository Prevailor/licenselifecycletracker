package com.training.licenselifecycletracker.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.training.licenselifecycletracker.entities.Software;
import com.training.licenselifecycletracker.exceptions.SoftwareNotFoundException;
import com.training.licenselifecycletracker.repositories.SoftwareRepository;
//@Service
//public class SoftwareServiceImpl implements SoftwareService{
//	
//	@Autowired
//    SoftwareRepository repo;
//
//	@Override
//	public Software addSoftware(Software software) {
//		return repo.save(software);
//	}
//
//	@Override
//    public ResponseEntity<List<Software>> viewSoftwares()  {
//        List<Software> softwares = (List<Software>) repo.findAll();
//        if (softwares.isEmpty()) {
//           return null;
//        }
//        return ResponseEntity.ok(softwares);
//    }
//	
//	@Override
//	public Software getSoftwareById(Integer softwareId) {
//         Optional<Software> software = repo.findById(softwareId);
//			if(software.isPresent()) {
//				
//				return software.get();
//			}else {
//			     return null;
//			}
//		
//	}
//
//	
//
//	
//
//	
//	public Software getSoftwareByName(String softwareName)  {
//		Software software= repo.findBySoftwareName(softwareName);
//		if(software != null) {		
//			return software;
//		}else {
//			
//			return null;
//		}
//	}
//
//	public List<Software> getSoftwareByStatus(String status) {
//        List<Software> software = (List<Software>) repo.findByStatus(status);
//        if(software.isEmpty()) {
//        	return null;
//        }
//        return software;
//    }
//	
//	@Override
//	public Software updateSoftware(Software software) {
//		Optional<Software> softwares = repo.findById(software.getSoftwareId());
//		if (softwares.isPresent()) {
//			return repo.save(software);
//		} else {
//			return null;
//		}
//	}
//
//	
//
//	@Override
//	public String deleteSoftwareById(Integer softwareId) {
//		Optional<Software> person = repo.findById(softwareId);
//		if (person.isPresent()) {
//			repo.deleteById(softwareId);
//			return "Software with Id " + softwareId + " deleted successfully";
//		} else {
//			return "Software with softwareId " + softwareId + " doesn't exists";
//		}
//	}
//	
//	@Override
//	public List<Software> getSoftwareByLicenseKey(String licenseKey) {
//		 List<Software> software = (List<Software>) repo.findByLicenseKey(licenseKey);
//	        if(software.isEmpty()) {
//	        	return null;
//	        }
//	        return software;
//		
//	}
//
//	@Override
//	public List<Software> getSoftwareByPurchaseDate(Date purchaseDate) {
//		List<Software> software = (List<Software>) repo.findByPurchaseDate(purchaseDate);
//        if(software.isEmpty()) {
//        	return null;
//        }
//        return software;
//	}
//
//	@Override
//	public List<Software> getSoftwareByExpirationDate(Date expirationDate) {
//		List<Software> software = (List<Software>) repo.findByExpirationDate(expirationDate);
//        if(software.isEmpty()) {
//        	return null;
//        }
//        return software;
//	}
//
//	@Override
//	public List<Software> getSoftwareBySupportEndDate(Date supportEndDate) {
//		List<Software> software = (List<Software>) repo.findBySupportEndDate(supportEndDate);
//        if(software.isEmpty()) {
//        	return null;
//        }
//        return software;
//	}
//
//	
//	
//	
//}


@Service
public class SoftwareServiceImpl implements SoftwareService {

    @Autowired
    SoftwareRepository repo;
    
    @Autowired
    NotificationService notificationService;

    @Override
    public Software addSoftware(Software software) {
        return repo.save(software);
    }

    @Override
    public ResponseEntity<List<Software>> viewSoftwares() throws SoftwareNotFoundException {
        List<Software> softwares = (List<Software>) repo.findAll();
        if (softwares.isEmpty()) {
            throw new SoftwareNotFoundException("No Softwares Found");
        }
        return ResponseEntity.ok(softwares);
    }

    @Override
    public Software getSoftwareById(Integer softwareId) throws SoftwareNotFoundException {
        Optional<Software> software = repo.findById(softwareId);
        if (software.isPresent()) {
            return software.get();
        } else {
            throw new SoftwareNotFoundException("Software with Id " + softwareId + " not found");
        }
    }

    public Software getSoftwareByName(String softwareName) throws SoftwareNotFoundException {
        Software software = repo.findBySoftwareName(softwareName);
        if (software != null) {
            return software;
        } else {
            throw new SoftwareNotFoundException("Software with name " + softwareName + " not found");
        }
    }

    public List<Software> getSoftwareByStatus(String status) throws SoftwareNotFoundException {
        List<Software> software = (List<Software>) repo.findByStatus(status);
        if (software.isEmpty()) {
            throw new SoftwareNotFoundException("No softwares found with status: " + status);
        }
        return software;
    }

    @Override
    public Software updateSoftware(Software software) throws SoftwareNotFoundException {
        Optional<Software> softwares = repo.findById(software.getSoftwareId());
        if (softwares.isPresent()) {
            return repo.save(software);
        } else {
            throw new SoftwareNotFoundException("Software with Id " + software.getSoftwareId() + " not found");
        }
    }

    @Override
    public String deleteSoftwareById(Integer softwareId) throws SoftwareNotFoundException {
        Optional<Software> software = repo.findById(softwareId);
        if (software.isPresent()) {
            repo.deleteById(softwareId);
            return "Software with Id " + softwareId + " deleted successfully";
        } else {
            throw new SoftwareNotFoundException("Software with Id " + softwareId + " not found");
        }
    }

    @Override
    public List<Software> getSoftwareByLicenseKey(String licenseKey) throws SoftwareNotFoundException {
        List<Software> software = (List<Software>) repo.findByLicenseKey(licenseKey);
        if (software.isEmpty()) {
            throw new SoftwareNotFoundException("No softwares found with license key: " + licenseKey);
        }
        return software;
    }

    @Override
    public List<Software> getSoftwareByPurchaseDate(Date purchaseDate) throws SoftwareNotFoundException {
        List<Software> software = (List<Software>) repo.findByPurchaseDate(purchaseDate);
        if (software.isEmpty()) {
            throw new SoftwareNotFoundException("No softwares found with purchase date: " + purchaseDate);
        }
        return software;
    }

    @Override
    public List<Software> getSoftwareByExpirationDate(Date expirationDate) throws SoftwareNotFoundException {
        List<Software> software = (List<Software>) repo.findByExpirationDate(expirationDate);
        if (software.isEmpty()) {
            throw new SoftwareNotFoundException("No softwares found with expiration date: " + expirationDate);
        }
        return software;
    }

    @Override
    public List<Software> getSoftwareBySupportEndDate(Date supportEndDate) throws SoftwareNotFoundException {
        List<Software> software = (List<Software>) repo.findBySupportEndDate(supportEndDate);
        if (software.isEmpty()) {
            throw new SoftwareNotFoundException("No softwares found with support end date: " + supportEndDate);
        }
        return software;
    }

	
    
    

    public void receiveNotifications() {
        List<Software> expiringSoftware = retrieveExpiringSoftware();

        for (Software software : expiringSoftware) {
            String message = "Your software license (ID: " + software.getSoftwareId() + ") is expiring soon. Renew now to avoid service disruptions.";
            notificationService.sendGeneralNotification(message);
        }
    }

    private List<Software> retrieveExpiringSoftware() {
        // Calculate the date 30 days from now
        LocalDate thirtyDaysFromNow = LocalDate.now().plusDays(30);
        
        // Retrieve expiring software from the database
        return repo.findByExpirationDateBefore(thirtyDaysFromNow);
    }


}