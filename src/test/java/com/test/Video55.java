package com.test;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class Video55 {
	
	@Test
	public void extract_response()
	{
		// In order to extract the rsponse we need to use extract() method and then use response();
	Response response =	given().
		baseUri("https://api.getpostman.com/").
		header("X-API-Key","PMAK-60b258969190c80034a17957-fae158d07a8145f9478adc930a616bd2c0")
		.when().
		get("workspaces").
		then().
		assertThat().
		statusCode(200).extract().response();
	System.out.println(response.asString());
	}

}
