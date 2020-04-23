package tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import constants.Constants;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;



public class Update_user_Update_Request {
	Constants constants = new Constants();
	Logger log = null;
	@Test
	public void validate_User_able_to_update_Current_resources() throws Exception{
		log = Logger.getLogger(Update_user_Update_Request.class);
		PropertyConfigurator.configure(constants.CONFIG_LOG4J_FILE_PATH);
		log.info(" Open URI url - https://reqres.in/api/users/2 and User able to Register" );
		Constants constants = new Constants();
		try {
		//int user_id =2;
		RestAssured.baseURI="https://reqres.in/api";
		RestAssured.basePath="/users";
		File json = new File (constants.CONFIG1_WEB_FILE_PATH);
		Response response = given().contentType(ContentType.JSON).log().all().body(json).put("2");
		response.prettyPrint();
		 log.info("Test Case Executed " );
	} catch (Exception e) {

		throw new Exception(e.getMessage());
	}
	}
	
	
	
}
