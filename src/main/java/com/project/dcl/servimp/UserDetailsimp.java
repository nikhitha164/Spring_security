package com.project.dcl.servimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.dcl.Exception.AppException;
import com.project.dcl.entity.User;
import com.project.dcl.repo.Userrepo;

@Service
public class UserDetailsimp implements UserDetailsService{
    
	@Autowired
	private Userrepo urepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User entity =urepo.findByEmail(email).orElseThrow(()->new AppException("User not found..!",HttpStatus.NOT_FOUND));
		return  new UserSDetailsservimp(entity);
	}

}
