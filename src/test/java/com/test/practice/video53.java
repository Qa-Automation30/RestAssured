package com.test.practice;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class video53 {
	
	@Test
	public void validateStatusCode()
	{
		given().baseUri("https://api.getpostman.com/").
		header("X-API-Key","PMAK-60b258969190c80034a17957-fae158d07a8145f9478adc930a616bd2c0")
		.when()
		.get("workspaces")
		.then().assertThat()
		.statusCode(200);
	}
	@Test
	public void validateStatusCode1()
	{
		given().
		baseUri("https://api.getpostman.com/").
		header("X-API-Key","PMAK-60b258969190c80034a17957-fae158d07a8145f9478adc930a616bd2c0").
		when().
		get("workspaces").
		then().
		assertThat().
		statusCode(200).log().all();
	}
	@Test
	public void validateStatusCode2()
	{
		given().
		baseUri("https://api.getpostman.com/").
		header("X-API-Key","PMAK-60b258969190c80034a17957-fae158d07a8145f9478adc930a616bd2c0").
		when().
		get("workspaces").then().log().all().statusCode(201);
	}

}
