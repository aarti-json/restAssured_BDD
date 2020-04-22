package tests;


import org.testng.annotations.Test;

import constants.Constants;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

import java.io.File;

import static io.restassured.RestAssured.*;



public class GetApi_user {
	
	@Test
	public void GetUserDEtails()
	{
	  
		/*given()
		.when()
		    .get("https://reqres.in/api/users?page=2")
		    .then()
		    .statusCode(200)
		    .statusLine("HTTP/1.1 200 OK")
		
		
		   .assertThat().body("page", equalTo("2"));*/
		
    Constants constants = new Constants();
		
		
		RestAssured.baseURI="https://reqres.in/api";
		RestAssured.basePath="/users";
		File json = new File (constants.CONFIG1_WEB_FILE_PATH);
		Response response = given().contentType(ContentType.JSON).log().all().body(json)
				.get("2");
		response.prettyPrint();
		    
		
		
	}


}
