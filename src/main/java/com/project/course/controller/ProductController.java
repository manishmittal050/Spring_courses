package com.project.course.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.project.course.entity.User;
import com.project.course.repository.UserRepository;

@Controller
public class ProductController {
	
	@Autowired
	private UserRepository userRepo;
	
	public String fetchAllProducts()
	{
		Iterable<User> userList = new ArrayList();
//		User user = userRepo.findByUsername("manish");
		
		List<User> ul = null;
		try {
			ul = (List<User>) userRepo.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		System.out.println("user List :: "+ ul);
		return "SS" ;
	}

}
