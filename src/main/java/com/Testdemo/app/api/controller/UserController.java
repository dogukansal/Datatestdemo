package com.Testdemo.app.api.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Testdemo.app.api.model.User;
import com.Testdemo.app.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.ui.Model;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	//kök url yani localhost:8080 e bağlandığında Login.html çalışır.
	@GetMapping("/")
	public String home() {
		
		return "Login";
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(String email, String password, Model model) {
		//Login.htmlden gelen email ve password parametresini service ile sorguluyoruz.
	    User user = userService.findByEmail(email);
	    
	    //kullanıcı yoksa 400 hata kodu dönen mesaj iletiyoruz
	    if (user == null) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Böyle bir kullanıcı yok.");
	    }
	    
	    //gelen parametre eğer kayıtlı kullanıcının password u ile eşit değilse 400 hata kodu ile mesaj iletiyoruz 
	    if (!user.getPassword().equals(password)) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Geçersiz e-posta veya şifre.");
	    }
	    //Eğer şartlar uyuyorsa home.html sayfasına yönlendiriyor ve homehtml işlem yapmak için veriyi aktarıyor.

	    return ResponseEntity.ok().body("redirect:/home");
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(User user, Model model) {
		//kullanıcının register.html deki inputları doldurup doldurmadığını, email adresini düzgün tipte yazıp yazmadığını, adresin
		//yeterli aralıklarda olup olmadığını sorguluyoruz.
	    String error = validateUser(user);
	    
	    if (error != null) {
	        model.addAttribute("error", error);
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	    }
	    
	  //şartlar uygunsa kullanıcıyu listte ekler ve 200 koduyla yaratıldığı mesajını söyler
	    userService.addUser(user);
	    return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully.");
	}

	private String validateUser(User user) {
		
		if (user.getName() == null || user.getLastname() == null || user.getEmail() == null || user.getPassword() == null  || user.getPasswordRepeat() == null || user.getAddress() == null ) {
			return "Please fill in the blanks";
		}
	    if (!user.getPassword().equals(user.getPasswordRepeat())) {
	        return "Passwords do not match.";
	    }

	    if (!user.getEmail().matches("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]+$")) {
	        return "Invalid email address.";
	    }

	    if (user.getAddress().length() < 20 || user.getAddress().length() > 250) {
	        return "Address must be between 20 and 250 characters long.";
	    }

	    return null;
	}
	
	//home.html deki değişkenlere user bilgilerini döndürüyoruz. 
	@GetMapping("/home")
	public String homeScreen(User user, Model model) {
	    model.addAttribute("user", user);
	    return "home";
	}
	
	
	
}



