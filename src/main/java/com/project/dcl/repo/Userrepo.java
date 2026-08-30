package com.project.dcl.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.dcl.entity.User;
@Repository
public interface Userrepo extends JpaRepository<User, Integer>{
//Optional<>
	Optional<User> findByEmail(String email); 
}
