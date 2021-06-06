package com.test;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Video59_1 {
	
	@Test
	public void containsInAnyOrders()
	{
		//containsInAnyOrder() --is method me order matter nai karta hai
		given().
		baseUri("https://api.getpostman.com/").
		header("X-API-Key","PMAK-60b258969190c80034a17957-fae158d07a8145f9478adc930a616bd2c0").
		when().get("workspaces").
		then().
		body("workspaces.name",containsInAnyOrder("My Workspace","Workspace1","testAPIWorkSpace"));
	}

}
