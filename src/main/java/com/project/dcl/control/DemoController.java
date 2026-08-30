package com.project.dcl.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dcl.dto.Userdto;
import com.project.dcl.request.Registerrequest;
import com.project.dcl.response.ApiResponse;
import com.project.dcl.service.UserService;

@RestController
@RequestMapping("/user")
public class DemoController {
    
//	@GetMapping("/login1")
//	public String login() {
//		return "This is login";
//	}
//	@GetMapping("/signup")
//	public String signup() {
//		return "This is signup";
//	}
//	@GetMapping("/Dashboard")
//	public String Dashboard() {
//		return "This is dashboard";
//	}
//	@GetMapping("/logout")
//   public String logout	(){
//       return "This is logout";
//	}
	@Autowired
	private UserService uservice;
	
	@PostMapping("/register")
public ResponseEntity<?>  Register(@RequestBody Registerrequest request ){
	Userdto dto =  uservice.Register(request);
	ApiResponse response=new ApiResponse<>("user registered successfully..!",null,HttpStatus.CONFLICT);
	return ResponseEntity.ok(response);
}
	
	
	
	
}
