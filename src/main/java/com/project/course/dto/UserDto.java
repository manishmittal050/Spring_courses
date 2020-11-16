package com.project.course.dto;

public class UserDto {
	
	public String userName;
	public String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "userDto [userName=" + userName + ", password=" + password + "]";
	}
	
	

}
