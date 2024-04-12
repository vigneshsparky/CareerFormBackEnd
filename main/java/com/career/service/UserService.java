package com.career.service;

import org.springframework.stereotype.Service;	
import com.career.entity.UserEntity;

@Service
public interface UserService {
	String registerCareerDetails(UserEntity entity);
}
