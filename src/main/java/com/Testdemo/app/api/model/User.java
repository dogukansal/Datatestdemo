package com.Testdemo.app.api.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class User {
	@NotBlank(message =" Name's can't be empty")
	private String name;
	@NotBlank(message =" lastname's can't be empty")
	private String lastname;
	@NotBlank(message =" email can't be empty")
	@Email
	private String email;
	@NotBlank(message =" password can't be empty")
	
	private String password;
	@NotBlank(message = " password confirm can't be empty")
	private String passwordRepeat;
	@NotBlank(message = " address can't be empty")
	@Size(min = 20, message= "Address must be min of 20 characters")
	private String address;
	
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordRepeat() {
		return passwordRepeat;
	}

	public void setPasswordRepeat(String passwordRepeat) {
		this.passwordRepeat = passwordRepeat;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
