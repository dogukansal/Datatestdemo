package Tests;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;

public class RegisterValidTest {
	
	 static String baseurl = "http://localhost:8080";
	
	public static void main(String[] args) {
		Register_WithValidPass_ReturnsStatusCode201();    //true form
		Register_PasswordNotMatch_ReturnsStatusCode400();  //false,password is not match
		Register_AddressNotLong_ReturnsStatusCode400();		//false, address is not long
		Register_EmailRegex_ReturnsStatusCode400();			//false, email is not have @
		Register_PasswordNot4LessCharacter_ReturnsStatusCode400();	//false, password must be more than 4 character
		Register_NameFieldNotEmpty_ReturnsStatusCode400(); 			//false, name field not be empty
		Register_LastNameFieldNotEmpty_ReturnsStatusCode400();		//false, lastname field not be empty
		Register_PasswordFieldNotEmpty_ReturnsStatusCode400();		//false, password field not be empty
		Register_PasswordRepeatFieldNotEmpty_ReturnsStatusCode400();		//false, password field not be empty
		Register_AddressFieldNotEmpty_ReturnsStatusCode400();			//false, address field not be empty
		
		Register_MissingNameParameters_ReturnsStatusCode400();		//false, Have not name parameters
		Register_MissingLastnameParameters_ReturnsStatusCode400();  //false, Have not lastname parameters
		Register_MissingPasswordParameters_ReturnsStatusCode400();  //false, Have not password parameters
		Register_MissingPasswordRepeatParameters_ReturnsStatusCode400();	//false, Have not passwordrepeat parameters
		Register_MissingEmailParameters_ReturnsStatusCode400();		//false, Have not email parameters
		Register_MissingAddressParameters_ReturnsStatusCode400();	//false, Have not address parameters
	}
	@Test
	public static void Register_WithValidPass_ReturnsStatusCode201() {
		String name = "mehmet";
		String lastname = "lale";
	    String password = "memo";
	    String passwordrepeat = "memo";
		String address = "Mehmet sokak lale apartmanı";
		String email = "mehmetlale@gmail.com";

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
        	.statusCode(201);
	}
	@Test
	public static void Register_PasswordNotMatch_ReturnsStatusCode400() {
		String name = "mehmet";
		String lastname = "lale";
	    String password = "memo";
	    String passwordrepeat = "memoli";
		String address = "Mehmet sokak lale apartmanı";
		String email = "mehmetlale@gmail.com";

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
        	.statusCode(400);
	}
	@Test
	public static void Register_AddressNotLong_ReturnsStatusCode400() {
		String name = "mehmet";
		String lastname = "lale";
	    String password = "memo";
	    String passwordrepeat = "memo";
		String address = "abc";
		String email = "mehmetlale@gmail.com";

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
        	.statusCode(400);
	}
	@Test
	public static void Register_EmailRegex_ReturnsStatusCode400() {
		String name = "mehmet";
		String lastname = "lale";
	    String password = "memo";
	    String passwordrepeat = "memo";
		String address = "Mehmet sokak lale apartmanı";
		String email = "abc.com";

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
        	.statusCode(400);
	}
	@Test
	public static void Register_PasswordNot4LessCharacter_ReturnsStatusCode400() {
		String name = "mehmet";
		String lastname = "lale";
	    String password = "a";
	    String passwordrepeat = "a";
		String address = "Mehmet sokak lale apartmanı";
		String email = "mehmetlale@gmail.com";

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
        	.statusCode(400);
	}
	@Test
	public static void Register_NameFieldNotEmpty_ReturnsStatusCode400() {
		String name = "";
		String lastname = "lale";
	    String password = "memo";
	    String passwordrepeat = "memo";
		String address = "Mehmet sokak lale apartmanı";
		String email = "mehmetlale@gmail.com";

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
        	.statusCode(400);
	}
	@Test
	public static void Register_LastNameFieldNotEmpty_ReturnsStatusCode400() {
		String name = "mehmet";
		String lastname = "";
	    String password = "memo";
	    String passwordrepeat = "memo";
		String address = "Mehmet sokak lale apartmanı";
		String email = "mehmetlale@gmail.com";

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
        	.statusCode(400);
	}
	@Test
	public static void Register_PasswordFieldNotEmpty_ReturnsStatusCode400() {
		String name = "mehmet";
		String lastname = "lale";
	    String password = "";
	    String passwordrepeat = "memo";
		String address = "Mehmet sokak lale apartmanı";
		String email = "mehmetlale@gmail.com";

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
        	.statusCode(400);
	}
	@Test
	public static void Register_PasswordRepeatFieldNotEmpty_ReturnsStatusCode400() {
		String name = "mehmet";
		String lastname = "lale";
	    String password = "memo";
	    String passwordrepeat = "";
		String address = "Mehmet sokak lale apartmanı";
		String email = "mehmetlale@gmail.com";

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
        	.statusCode(400);
	}
	@Test
	public static void Register_emailFieldNotEmpty_ReturnsStatusCode400() {
		String name = "mehmet";
		String lastname = "lale";
	    String password = "memo";
	    String passwordrepeat = "memo";
		String address = "Mehmet sokak lale apartmanı";
		String email = "";

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
        	.statusCode(400);
	}
	@Test
	public static void Register_AddressFieldNotEmpty_ReturnsStatusCode400() {
		String name = "mehmet";
		String lastname = "lale";
	    String password = "memo";
	    String passwordrepeat = "memo";
		String address = "";
		String email = "mehmetlale@gmail.com";

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
        	.statusCode(400);
	}

	@Test
	public static void Register_MissingNameParameters_ReturnsStatusCode400() {
		String lastname = "lale";
	    String password = "memo";
	    String passwordrepeat = "memo";
		String address = "Mehmet sokak lale apartmanı";
		String email = "mehmetlale@gmail.com";

		RestAssured.
		given()
        	.contentType("application/x-www-form-urlencoded")  
        	.formParam("lastname", lastname)
        	.formParam("password", password)
        	.formParam("passwordrepeat", passwordrepeat)
        	.formParam("email", email)
        	.formParam("address", address)
        .when()
        	.post(baseurl+"/register")
        .then()
        	.statusCode(400);
	}
	@Test
	public static void Register_MissingLastnameParameters_ReturnsStatusCode400() {
		String name = "mehmet";
	    String password = "memo";
	    String passwordrepeat = "memo";
		String address = "Mehmet sokak lale apartmanı";
		String email = "mehmetlale@gmail.com";

		RestAssured.
		given()
        	.contentType("application/x-www-form-urlencoded")  
        	.formParam("name", name)
        	.formParam("password", password)
        	.formParam("passwordrepeat", passwordrepeat)
        	.formParam("email", email)
        	.formParam("address", address)
        .when()
        	.post(baseurl+"/register")
        .then()
        	.statusCode(400);
	}
	@Test
	public static void Register_MissingPasswordParameters_ReturnsStatusCode400() {
		String name = "mehmet";
		String lastname = "lale";
	    String passwordrepeat = "memo";
		String address = "Mehmet sokak lale apartmanı";
		String email = "mehmetlale@gmail.com";

		RestAssured.
		given()
        	.contentType("application/x-www-form-urlencoded")  
        	.formParam("name", name)
        	.formParam("lastname", lastname)
        	.formParam("passwordrepeat", passwordrepeat)
        	.formParam("email", email)
        	.formParam("address", address)
        .when()
        	.post(baseurl+"/register")
        .then()
        	.statusCode(400);
	}
	@Test
	public static void Register_MissingPasswordRepeatParameters_ReturnsStatusCode400() {
		String name = "mehmet";
		String lastname = "lale";
	    String password = "memo";
		String address = "Mehmet sokak lale apartmanı";
		String email = "mehmetlale@gmail.com";

		RestAssured.
		given()
        	.contentType("application/x-www-form-urlencoded")  
        	.formParam("name", name)
        	.formParam("lastname", lastname)
        	.formParam("password", password)
        	.formParam("email", email)
        	.formParam("address", address)
        .when()
        	.post(baseurl+"/register")
        .then()
        	.statusCode(400);
	}
	@Test
	public static void Register_MissingEmailParameters_ReturnsStatusCode400() {
		String name = "mehmet";
		String lastname = "lale";
	    String password = "memo";
	    String passwordrepeat = "memo";
		String address = "Mehmet sokak lale apartmanı";

		RestAssured.
		given()
        	.contentType("application/x-www-form-urlencoded")  
        	.formParam("name", name)
        	.formParam("lastname", lastname)
        	.formParam("password", password)
        	.formParam("passwordrepeat", passwordrepeat)
        	.formParam("address", address)
        .when()
        	.post(baseurl+"/register")
        .then()
        	.statusCode(400);
	}
	@Test
	public static void Register_MissingAddressParameters_ReturnsStatusCode400() {
		String name = "mehmet";
		String lastname = "lale";
	    String password = "memo";
	    String passwordrepeat = "memo";

		String email = "mehmetlale@gmail.com";

		RestAssured.
		given()
        	.contentType("application/x-www-form-urlencoded")  
        	.formParam("name", name)
        	.formParam("lastname", lastname)
        	.formParam("password", password)
        	.formParam("passwordrepeat", passwordrepeat)
        	.formParam("email", email)
        .when()
        	.post(baseurl+"/register")
        .then()
        	.statusCode(400);
	}
	
}
