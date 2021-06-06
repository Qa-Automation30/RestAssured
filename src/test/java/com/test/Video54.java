package com.test;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Video54 {
	
	//Is video me hume response me jo body aa rai hai usko validate karna hai.
	// So wo hum body() method ke through kar sakte hai. But jo response aa raha hai wo json format me aa raha hai to usse kaise deal karege.
	
	@Test
	public void validateResponseBody()
	{
		given().baseUri("https://api.getpostman.com/").
		header("X-API-Key","PMAK-60b258969190c80034a17957-fae158d07a8145f9478adc930a616bd2c0")
		.when().get("workspaces").
		then().assertThat().statusCode(200).log().all().
		body("workspaces.name", hasItems("Workspace1", "My Workspace", "testAPIWorkSpace"),
				"workspaces.type",hasItems("personal","personal","personal"));
	}

	@Test
	public void validateResponseBody1()
	{
		// Ye wala fail hoga bcs maine personal1 likha hai
		given().baseUri("https://api.getpostman.com/").
		header("X-API-Key","PMAK-60b258969190c80034a17957-fae158d07a8145f9478adc930a616bd2c0")
		.when().get("workspaces").
		then().assertThat().statusCode(200).log().all().
		body("workspaces.name", hasItems("Workspace1", "My Workspace", "testAPIWorkSpace"),
				"workspaces.type",hasItems("personal","personal","personal1"));
	}
	
	@Test
	public void validateResponseBody2()
	{
		given().baseUri("https://api.getpostman.com/").
		header("X-API-Key","PMAK-60b258969190c80034a17957-fae158d07a8145f9478adc930a616bd2c0")
		.when().get("workspaces").
		then().assertThat().statusCode(200).log().all().
		body("workspaces[0].name",is(equalTo("Workspace1"))).body("workspaces.size",is(equalTo(3)));
	}

}
