package com.training.licenselifecycletracker.service;

import com.training.licenselifecycletracker.entities.User;
import com.training.licenselifecycletracker.exceptions.UserNotFoundException;

public interface UserService {
	
	//Create
		public User addUser(User User)throws UserNotFoundException;
		//Retrieve
		public User getUserById(Integer UserId)throws UserNotFoundException ;
		
		//Delete
		public String deleteUserById(Integer UserId)throws UserNotFoundException;
		
		//Update
		public User updateUser(User User)throws UserNotFoundException;
		
		public Boolean existsByUsername(String username);

}
