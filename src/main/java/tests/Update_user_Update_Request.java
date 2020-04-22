package tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

import org.testng.annotations.Test;

import constants.Constants;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;



public class Update_user_Update_Request {


	@Test
	public void validate_User_able_to_update_Current_resources(){
		
		Constants constants = new Constants();
		//int user_id =2;
		RestAssured.baseURI="https://reqres.in/api";
		RestAssured.basePath="/users";
		File json = new File (constants.CONFIG1_WEB_FILE_PATH);
		Response response = given().contentType(ContentType.JSON).log().all().body(json).put("2");
		response.prettyPrint();
	}
	
	
	
}
