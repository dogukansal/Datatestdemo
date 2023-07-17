package com.Testdemo.app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.Testdemo.app.api.model.User;

//@Service
public class UserService {
	 private List<User> users = new ArrayList<>();
	 
	 public void addUser(User user) {
		    users.add(user);
		  }
	 public List<User> getUsers() {
		    return users;
		  }

	 
	 public User findByEmail(String email) {
		    for (User user : users) {
		      if (user.getEmail().equals(email)) {
		        return user;
		      }
		    }
		    return null;
		  }
	
	
	
}




/* create ile kullanıcıyı oluştur. boş bırakmak yok. passwordlar eşit. adres maksimum minimum sınırda . adres doğru formatta. 
 * 
 *  User create post:
 *  payload: name,lastname,password,passwordagain,email,address
 *  İşlem başarılıysa kullanıcı list'e kaydedilecek.
 *  
 *  validasyon: parolalar aynı mı? password ile passwordagain ile kontrol edilecek. Email doğru formatta mı yazılmış? adres maksimum 250 minimum 20 karakterden oluşmalı
 *  Eğer bu şartlar uymuyorsa geriye kullanıcıyı uyaran hata dönmeli. Bu hata aynı sayfada gösterilecek.
 *  
 *  User get:
 *  Kullanıcı kayıt olduktan sonra eposta ve şifresiyle giriş yapacak. Eğer hatalıysa aynı sayfada kullanıcıyı uyaran hata dönmeli.
 *  Eğer kullanıcı doğru giriş yaptıysa kendi bilgilerini (name,lastname,password,passwordagain,email,address) gösteren bir sayfaya gitmeli.
 *  
 *  Tüm bunlar java dilinde, spring boot kullanılarak ve html sayfasında gözükecek şekilde yazılacaktır. 
 *  
 *  
 *  */