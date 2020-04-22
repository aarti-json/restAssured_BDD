package tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import constants.Constants;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utility.FileOperations;

public class Login_User_UnSucess_PostRequest {
	
	public static  HashMap map = new HashMap();
	FileOperations fileOperations = new FileOperations();
	Constants constants = new Constants();
	
	@BeforeClass
	public void postData(){
		
		
		map.put("email", "peter@klaven");
		
		
		RestAssured.baseURI="https://reqres.in/api";
		RestAssured.basePath="/login";
        Response response = given().contentType(ContentType.JSON).log().all().get("/");
		
		response.prettyPrint();
	}
	
	@Test
	public void validate_User_Not_able_to_Login(){
		given()
		.contentType("application/json")
		.body(map)
		.when()
		 .post()
		.then()
		 .statusCode(400)
		 .and()
		 .body("error", equalTo("Missing password"));
		
		
		
		
	}


}
