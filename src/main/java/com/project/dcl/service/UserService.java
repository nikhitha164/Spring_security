package com.project.dcl.service;



import com.project.dcl.dto.Userdto;
import com.project.dcl.request.Loginrequest;
import com.project.dcl.request.Registerrequest;


public interface UserService {
      public Userdto Register(Registerrequest request);
      
   
      }