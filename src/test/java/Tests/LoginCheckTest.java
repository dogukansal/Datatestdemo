package Tests;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class LoginCheckTest {
	
	static String baseurl = "http://localhost:8080";
	
	public static void main(String[] args) {
		login_WithValidPass_ReturnsStatusCode200();   //true form
		login_IncorrectPassword_ReturnsStatusCode400();	//false, wrong password
		login_UserNotFound_ReturnsStatusCode404(); 		//false, User not found
		login_EmailFieldNotEmpty_ReturnsStatusCode400(); 	//false , Email field not empty
		login_PasswordFieldNotEmpty_ReturnsStatusCode400();	 //false, password field not empty
		login_MissingPasswordParameter_ReturnsStatusCode400();  //false, Missing password parameters
		login_MissingEmailParameters_ReturnsStatusCode400();	//false, Missing email parameters
	}
	@Test
	public static void login_WithValidPass_ReturnsStatusCode200() {
	    String email = "mehmetlale@gmail.com";
	    String password = "memo";
		RestAssured
		.given()
        .param("email", email)
        .param("password", password)
        .when()
        .post(baseurl + "/login")
        .then()
        .statusCode(200);
	}
	@Test
	public static void login_IncorrectPassword_ReturnsStatusCode400() {
	    String email = "mehmetlale@gmail.com";
	    String password = "a";

		RestAssured
		.given()
        .param("email", email)
        .param("password", password)
        .when()
        .post(baseurl + "/login")
        .then()
        .statusCode(400);
	}

	@Test
	public static void login_UserNotFound_ReturnsStatusCode404() {
	    String email = "a@gmail.com";
	    String password = "b";
	    RestAssured
	    .given()
	    .param("email", email)
	    .param("password", password)
	    .when()
	    .post(baseurl + "/login")
	    .then()
	    .statusCode(404);
	}
	@Test
	public static void login_EmailFieldNotEmpty_ReturnsStatusCode400() {
	    String email = "";
	    String password = "a";
	    RestAssured
	    .given()
	    .param("email", email)
	    .param("password", password)
	    .when()
	    .post(baseurl + "/login")
	    .then()
	    .statusCode(400);
	}
	@Test
	public static void login_PasswordFieldNotEmpty_ReturnsStatusCode400() {
	    String email = "a@gmail.com";
	    String password = "";
	    RestAssured
	    .given()
	    .param("email", email)
	    .param("password", password)
	    .when()
	    .post(baseurl + "/login")
	    .then()
	    .statusCode(400);
	}
	
	@Test
	public static void login_MissingPasswordParameter_ReturnsStatusCode400() {
	    String email = "a@gmail.com";
	    RestAssured
	    .given()
	    .param("email", email)
	    .when()
	    .post(baseurl + "/login")
	    .then()
	    .statusCode(400);
	}
	
	@Test
	public static void login_MissingEmailParameters_ReturnsStatusCode400() {
	    String password = "";
	    RestAssured
	    .given()
	    .param("password", password)
	    .when()
	    .post(baseurl + "/login")
	    .then()
	    .statusCode(400);
	}
}
