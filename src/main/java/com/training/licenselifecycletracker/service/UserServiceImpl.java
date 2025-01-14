package com.training.licenselifecycletracker.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.licenselifecycletracker.entities.User;
import com.training.licenselifecycletracker.exceptions.UserNotFoundException;
import com.training.licenselifecycletracker.repositories.UserRepository;

//@Service
//public class UserServiceImpl implements UserService {
//
//	@Autowired
//	private UserRepository repo;
//	
//	
//	@Override
//	public User addUser(User user) {
//		return repo.save(user);
//	}
//
//	@Override
//	public User getUserById(Integer userId){
//		Optional<User> user = repo.findById(userId);
//		if(user.isPresent()) {
//			
//			return user.get();
//		}else {
//			return null;
//		}
//	}
//	
//	@Override
//	public String deleteUserById(Integer userId) {
//		
//			Optional<User> user = repo.findById(userId);
//			if (user.isPresent()) {
//				repo.deleteById(userId);
//				return "User with userId " + userId + " deleted successfully";
//			} else {
//					 return null;
//			}
//		}
//
//	@Override
//	public User updateUser(User user) {
//		Optional<User> users = repo.findById(user.getUserId());
//			if (users.isPresent()) {
//				return repo.save(user);
//			} else {
//					return null;
//			}
//		
//	}
//}

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    @Override
    public User addUser(User user) {
        return repo.save(user);
    }

    @Override
    public User getUserById(Integer userId) throws UserNotFoundException {
        Optional<User> user = repo.findById(userId);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UserNotFoundException("User with userId " + userId + " not found");
        }
    }

    @Override
    public String deleteUserById(Integer userId) throws UserNotFoundException {
        Optional<User> user = repo.findById(userId);
        if (user.isPresent()) {
            repo.deleteById(userId);
            return "User with userId " + userId + " deleted successfully";
        } else {
            throw new UserNotFoundException("User with userId " + userId + " not found");
        }
    }

    @Override
    public User updateUser(User user) throws UserNotFoundException {
        Optional<User> users = repo.findById(user.getUserId());
        if (users.isPresent()) {
            return repo.save(user);
        } else {
            throw new UserNotFoundException("User with userId " + user.getUserId() + " not found");
        }
    }
    
    
    @Override
	public Boolean existsByUsername(String username) {
		Boolean b=repo.existsByUsername(username);
		return b;
	}
 
}
