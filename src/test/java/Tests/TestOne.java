package Tests;


import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class TestOne {

	static String baseurl = "http://localhost:8080";
	
	public static void main(String[] args) {
		testPostUserAPI("mehmet","lale","memo","memo","mehmetlale@gmail.com","2 twix 2 bounty 1 snickers",201); //true, created
		testPostUserAPI("mehmet","lale","memo","mem","mehmetlale@gmail.com","2 twix 2 bounty 1 snickers",400); //false,password is not match
		testPostUserAPI("mehmet","lale","memo","memo","mehmetlale@gmail.com","2 twix",400); //false, address is not long
		testPostUserAPI("mehmet","lale","memo","memo","mehmetlalegmail.com","2 twix 2 bounty 1 snickers",400); //false, email is not have testPostUserAPI("","lale","memo","memo","mehmetlale@gmail.com","2 twix 2 bounty 1 snickers",400); //false, name is empty 
		
	}
	 
	
	
	@Test
	public void testLoginUserAPI(String email, String password,int statuscode) {
		RestAssured.
		given()
		.param("email", email)
		.param("password", password)
		.when()
			.get(baseurl+"/login")
		.then()
		.statusCode(statuscode);

		
		} //Login.html  //login olma durumunu sorgular. eğer email adresi veya şifreyi yanlış girerse 400 kodu fırlatır.
	
	
	@Test
	public static void testPostUserAPI(String name, String lastname, String password, String passwordrepeat, String email, String address, int statuscode) {
		RestAssured.
		given()
        	.contentType("application/x-www-form-urlencoded")  
        	.formParam("name", name)
        	.formParam("lastname", lastname)
        	.formParam("password", password)
        	.formParam("passwordrepeat", passwordrepeat)
        	.formParam("email", email)
        	.formParam("address", address)
        .when()
        	.post(baseurl+"/register")
        .then()
        	.statusCode(statuscode);
	}
	
}

