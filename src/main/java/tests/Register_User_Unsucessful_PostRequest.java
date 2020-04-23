package tests;

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
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class Register_User_Unsucessful_PostRequest {

	public static HashMap map = new HashMap();
	FileOperations fileOperations = new FileOperations();
	Constants constants = new Constants();
	Logger log = null;
	@BeforeClass
	public void postData() {

		map.put("email", "peter@klaven");
		RestAssured.baseURI = "https://reqres.in/api";
		RestAssured.basePath = "/register";
		Response response = given().contentType(ContentType.JSON).log().all().get();
		response.prettyPrint();
	}

	@Test
	public void validate_User_Not_able_to_Register() throws Exception {
		try {
		log = Logger.getLogger(Register_User_Unsucessful_PostRequest.class);
		PropertyConfigurator.configure(constants.CONFIG_LOG4J_FILE_PATH);
		log.info(" Open URI url - https://reqres.in/api/register and User Not able to Register" );
		given()
		.contentType("application/json")
		.body(map).when()
		.post()
		.then()
		.statusCode(400)
		.and()
		.body("error", equalTo("Missing password"));
		log.info("Test Case Executed " );
		
	} catch (Exception e) {

		throw new Exception(e.getMessage());
	}
	}

}
