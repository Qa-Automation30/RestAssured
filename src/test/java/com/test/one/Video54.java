package com.test.one;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Video54 {
	@Test
	public void validateResponseBody1()
	{
		// hasItems() methods array me bus yai dekhta hai ki wo element array me present hai ya nai.
		// ye matter nai karta ki uska order kya hai ya fir us array me kitni vlaue hai
		given().
		baseUri("https://api.getpostman.com/").
		header("X-API-Key","PMAK-60b258969190c80034a17957-fae158d07a8145f9478adc930a616bd2c0").
		when().get("workspaces").then().
		body("workspaces.name", hasItems("Workspace1", "My Workspace", "testAPIWorkSpace")).
		body("workspaces.name",hasItems("Workspace1", "My Workspace")).
		body("workspaces.name",hasItems("My Workspace","Workspace1"));
	}
	
	@Test
	public void validateResponseBody2()
	{
		//is(equalTo("Workspace1")) -> Ye method puri response body me agar 1 value ko validate karna hai to likte hai
		
		given().
		baseUri("https://api.getpostman.com/").
		header("X-API-Key","PMAK-60b258969190c80034a17957-fae158d07a8145f9478adc930a616bd2c0").
		when().get("workspaces").then().
		body("workspaces[0].name",is(equalTo("Workspace1"))).
		body("workspaces[0].type",is(equalTo("personal")));
	}
	
	@Test
	public void validateTheSizeForResponseBody()
	{
		//Response ke array size ko validate karna hai to aise karege
		
		given().
		baseUri("https://api.getpostman.com/").
		header("X-API-Key","PMAK-60b258969190c80034a17957-fae158d07a8145f9478adc930a616bd2c0").
		when().get("workspaces").then().
		body("workspaces.size",is(equalTo(3)));
	}


}
