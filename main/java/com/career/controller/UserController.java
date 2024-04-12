package com.career.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;	
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.career.emailservice.EmailService;
import com.career.entity.UserEntity;
import com.career.service.FileStorageService;
import com.career.service.UserService;

@RestController
public class UserController {
	@Autowired
	FileStorageService fileStorageService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	EmailService emailService;
//	emailService.sendEmail(recipientEmail, emailSubject, emailBody);
	
	@PostMapping(value = "/registerCareer")
	private ResponseEntity<?> infoCareer(@RequestParam("file") MultipartFile file,@RequestBody UserEntity entity) {
		String onregister = new Date().toString();
		entity.setOnRegister(onregister);
		
		  String filePath = "E:\\Projects\\CareerForm\\FileDetails" + file.getOriginalFilename();
	        try {
	            file.transferTo(new File(filePath));
	        } catch (IOException e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading file.");
	        }
		
		
	     // Set the file path in the UserEntity
	        entity.setUserFile(filePath);
		
		
		String name = entity.getUserName();
		String upperCase = name.toUpperCase();
		String userEmail = entity.getUserEmail();
		
		String recipientEmail = userEmail;
		String emailSubject = "Welcome to Company Name.";
		String emailBody = "Dear " + upperCase + "\n\n Thank you for your interest in Company Name! \n\nThank you for registering. We will get back to you within next 24 hours.";
		emailService.sendEmail(recipientEmail, emailSubject, emailBody);
		
		
		String companyEmail = "vigneshwaran2020win@gmail.com";
		String companySubject = "All Cantidate Details";
		String companyBody = "No of Cantidate";
		
		emailService.sendEmail(companyEmail, companySubject, companyBody);
		
		String registerCareerDetails = userService.registerCareerDetails(entity);
		return new ResponseEntity<String>(registerCareerDetails,HttpStatus.OK);
	}
}
