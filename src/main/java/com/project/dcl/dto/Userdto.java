package com.project.dcl.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Userdto {


	private Integer userId;
	
	private String username;
	
	private String email;
	
	private LocalDate createdAt;
}
