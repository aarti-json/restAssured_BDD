package tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import constants.Constants;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utility.FileOperations;

public class Login_User_Sucess_PostRequest {

	public static HashMap map = new HashMap();
	FileOperations fileOperations = new FileOperations();
	Constants constants = new Constants();
	Logger log = null;
	@BeforeClass
	public void postData() {
		
		Constants constants = new Constants();
		map.put("password", "cityslicka");
		map.put("email", "eve.holt@reqres.in");

		RestAssured.baseURI = "https://reqres.in/api";
		RestAssured.basePath = "/login";

		/*
		 * File json = new File (constants.CONFIG2_WEB_FILE_PATH); Response
		 * response =
		 * given().contentType(ContentType.JSON).log().all().body(json).post();
		 * response.prettyPrint();
		 */
	}

	@Test
	public void validate_User_able_to_Login() throws Exception {
		
		Constants constants = new Constants();
		log = Logger.getLogger(Login_User_Sucess_PostRequest.class);
		PropertyConfigurator.configure(constants.CONFIG_LOG4J_FILE_PATH);
		File json = new File(constants.CONFIG2_WEB_FILE_PATH);
		log.info(" Open URI url - https://reqres.in/api/login  and validate User_able_to_Login" );
		
		try {
		
		Response response = given().contentType(ContentType.JSON).log().all().body(json).post();
		response.prettyPrint();
		given()
		.contentType("application/json")
		  .accept("application/json")
		      .body(json)
		      .when()
		       .post()
		        .then().assertThat()
				.statusCode(200)
				 .and()
				  .body("token", equalTo("QpwL5tke4Pnpja7X4")).and().extract().response();
		
		log.info("Test Case Executed " );
		} catch (Exception e) {

			throw new Exception(e.getMessage());
		}
	}

}
