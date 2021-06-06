package com.test;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class Video59 {
	
	@Test
	public void hameCrestCollection1()
	{
		// Contains method me order matter karta hai means jis order me response aa raha hai usi order me agar validate karege to test case pass hoga.
		// Contains method me sare ke sare elements validate karne ke liye daalne padege nai to test case fail hoga
		// Jis order me ayege usi order me validate karege (Strict binding hai)
		given().
		baseUri("https://api.getpostman.com/").
		header("X-API-Key","PMAK-60b258969190c80034a17957-fae158d07a8145f9478adc930a616bd2c0").
		when().
		get("workspaces").
		then().assertThat().statusCode(200).
		body("workspaces.name",contains("Workspace1", "My Workspace","testAPIWorkSpace"));
	}
	@Test
	public void hameCrestCollection2()
	{
		given().
		baseUri("https://api.getpostman.com/").
		header("X-API-Key","PMAK-60b258969190c80034a17957-fae158d07a8145f9478adc930a616bd2c0").
		when().
		get("workspaces").
		then().assertThat().statusCode(200).
		body("workspaces.name",contains("My Workspace","testAPIWorkSpace"));
	}
	@Test
	public void hameCrestCollection3()
	{
		// Ye test case fail hoga bcs isme order jo hai wo diff hai. 
		given().
		baseUri("https://api.getpostman.com/").
		header("X-API-Key","PMAK-60b258969190c80034a17957-fae158d07a8145f9478adc930a616bd2c0").
		when().
		get("workspaces").
		then().assertThat().statusCode(200).
		body("workspaces.name",contains("My Workspace","testAPIWorkSpace","Workspace1"));
	}

}
