package com.career.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;			
import org.springframework.stereotype.Component;
import com.career.entity.UserEntity;
import com.career.repository.UserRepository;
import com.career.service.UserService;

@Component
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository repo;
	@Override
	public String registerCareerDetails(UserEntity entity) {
		String userEmail = entity.getUserEmail();
		if(repo.existsById(userEmail)) {
			return "Already Registered";
		}
		
		try {
			UserEntity save = repo.save(entity);
		} catch (Exception e) {
			return null;
		}
		
		return "Register Successfully";
	}	
}
