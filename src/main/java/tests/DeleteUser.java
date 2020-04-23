package tests;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import constants.Constants;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;


public class DeleteUser {
	Logger log = null;
	Constants constants = new Constants();
	@Test
	 public void validate_delete_user() throws Exception{
		
		try {
		log = Logger.getLogger(DeleteUser.class);
		PropertyConfigurator.configure(constants.CONFIG_LOG4J_FILE_PATH);
		
		log.info(" Open URI url - https://reqres.in/api/users/2  and validate Delete User" );
		RestAssured.baseURI="https://reqres.inn";
		RestAssured.basePath="/api/users/2";
		
		 given()
		 .contentType("application/json")
		.when()
		.delete()
		.then()
		.statusCode(204)
		.statusLine("HTTP/1.1 204 No Content")
		.log().all();
		
		 log.info("Test Case Executed " );
		 
		} catch (Exception e) {

			throw new Exception(e.getMessage());
		}
		
	}

}
