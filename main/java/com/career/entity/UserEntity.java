package com.career.entity;

import jakarta.persistence.Column;	
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
//import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "careerformdetails")
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
	@Column(name = "USERNAME")
	private String userName;
	@Id
	@Column(name = "USEREMAIL")
	private String userEmail;
	@Column(name = "USERPHNUM")
	private String userPhNum;
	@Column(name = "USERPOSITION")
	private String userPosition;
	@Column(name = "USERDISCRIPTION")
	private String userDiscription;
	@Column(name = "ONREGISTER")
	private String onRegister;
	@Lob
	@Column(name = "USERFILE")
	private String userFile;
}
