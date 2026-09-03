package com.project.dcl.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dcl.Exception.AppException;
import com.project.dcl.dto.Userdto;
import com.project.dcl.request.Loginrequest;
import com.project.dcl.request.Registerrequest;
import com.project.dcl.response.ApiResponse;
import com.project.dcl.service.UserService;
import com.project.dcl.servimp.UserDetailsimp;

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
	private AuthenticationManager authManager;
	
	@Autowired
	private PasswordEncoder encoder;

	
	@Autowired
	private UserDetailsimp userdetails;
	@Autowired
	private UserService uservice;
	
	@PostMapping("/register")
public ResponseEntity<?>  Register(@RequestBody Registerrequest request ){
	Userdto dto =  uservice.Register(request);
	ApiResponse response=new ApiResponse<>("user registered successfully..!",null,HttpStatus.OK);
	return ResponseEntity.ok(response);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Loginrequest request){
	UserDetails userDetails=userdetails.loadUserByUsername(request.getEmail());
	//PASSWORD VALIDATION
	if(!encoder.matches(request.getPassword(),userDetails.getPassword())) {
		throw new AppException("Incorrect Password", HttpStatus.UNAUTHORIZED);
	}
	
	UsernamePasswordAuthenticationToken token=new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());
	Authentication authentication=authManager.authenticate(token);
	if(!authentication.isAuthenticated()) {
		throw new AppException("Failed to Login!", HttpStatus.UNAUTHORIZED);
	}
	
	ApiResponse response=new ApiResponse<>("Login Successful!",null, HttpStatus.OK);
	
	return ResponseEntity.ok(response);

	
	}
	
}
