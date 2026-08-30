package com.project.dcl.servimp;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.dcl.Exception.AppException;
import com.project.dcl.dto.Userdto;
import com.project.dcl.entity.User;
import com.project.dcl.repo.Userrepo;
import com.project.dcl.request.Registerrequest;
import com.project.dcl.service.UserService;



@Service
public class servimp implements UserService {
	@Autowired
	private Userrepo urepo;

	
   @Autowired
    private ModelMapper mapper;
	@Override
	public Userdto Register(Registerrequest request) {
		User existinguser = urepo.findByEmail(request.getEmail()).orElse(null);
		if(existinguser!=null) {
			throw new AppException("user not found..!",HttpStatus.CONFLICT);
		}
		User newuser= mapper.map(request,User.class);
		newuser = urepo.save(newuser);
		   Userdto dto = mapper.map(newuser, Userdto.class);
		    return dto;
	}

}
