package com.project.course.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.course.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

	User findByUsername(String string);
	
	
	

}
