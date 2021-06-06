package com.test;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Video56 {
	
	// hum response me se single value ko kai tarike se extract kar sakte hai. 
	// Jiske liye humne yaha pe code likha hau hai.
	@Test
	public void validateSingleValueFromResponse1()
	{
		// here we use grooy's jpath expression to extract the single value from json format
		Response response =	given().
				baseUri("https://api.getpostman.com/").
				header("X-API-Key","PMAK-60b258969190c80034a17957-fae158d07a8145f9478adc930a616bd2c0")
				.when().
				get("workspaces").
				then().
				assertThat().
				statusCode(200).extract().response();
		System.out.println("================================");
			System.out.println(response.path("workspaces[0].name"));
	}
	@Test
	public void validateSingleValueFromResponse2()
	{
		// here we use grooy's jpath expression to extract the single value from json format
		Response response =	given().
				baseUri("https://api.getpostman.com/").
				header("X-API-Key","PMAK-60b258969190c80034a17957-fae158d07a8145f9478adc930a616bd2c0")
				.when().
				get("workspaces").
				then().
				assertThat().
				statusCode(200).extract().response();
	//Now the 2nd way to create and instance of jsonpath.
		JsonPath jsnpath = new JsonPath(response.asString());
		System.out.println("================================");
		System.out.println(jsnpath.getString("workspaces[0].name"));
	}
	@Test
	public void validateSingleValueFromResponse3()
	{
		// here we use grooy's jpath expression to extract the single value from json format
		Response response =	given().
				baseUri("https://api.getpostman.com/").
				header("X-API-Key","PMAK-60b258969190c80034a17957-fae158d07a8145f9478adc930a616bd2c0")
				.when().
				get("workspaces").
				then().
				assertThat().
				statusCode(200).extract().response();
		System.out.println("================================");
		// ye third way hai likhne ka
		System.out.println(JsonPath.from(response.asString()).getString("workspaces[0].name"));
	}

}
