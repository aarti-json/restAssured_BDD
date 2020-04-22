package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import constants.Constants;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utility.FileOperations;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;


public class DeleteUser {
	
	@Test
	public void validate_delete_user(){
		
		
		RestAssured.baseURI="https://reqres.in";
		RestAssured.basePath="/api/users/2";
		
		 given()
		 .contentType("application/json")
		.when()
		.delete()
		.then()
		.statusCode(204)
		.statusLine("HTTP/1.1 204 No Content")
		.log().all();
		
		
		
	}

}
