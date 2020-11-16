package com.project.course.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.project.course.dto.UserDto;
import com.project.course.entity.User;
import com.project.course.repository.UserRepository;

@Controller
public class LogInController {
	
	@Autowired
	private UserRepository userRepository;
	

	
	public String validateUserAndPassword(UserDto userDto)
	{
		System.out.println("Controller get cALLED"+ userDto.toString());
		User user = new User();
		
		user.setUsername(userDto.getUserName());
		user.setPassword(userDto.getPassword());
		
		userRepository.save(user);
		
		List<User> ul = (List<User>) userRepository.findAll();
		
		
		System.out.print("::::::: "+ul.get(0));
		
		
		return "Success";
	}
	
	
	public String fetchAllProducts()
	{
		Iterable<User> userList = new ArrayList();
//		User user = userRepo.findByUsername("manish");
		
		List<User> ul = null;

			ul = (List<User>) userRepository.findAll();

		
		
		
		
		System.out.println("user List :: "+ ul);
		return "SS" ;
	}

}
