package com.test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class Video57 {
	
	@Test
	public void hamcrest_Assert()
	{
		// here we use grooy's jpath expression to extract the single value from json format
		String name =	given().
				baseUri("https://api.getpostman.com/").
				header("X-API-Key","PMAK-60b258969190c80034a17957-fae158d07a8145f9478adc930a616bd2c0")
				.when().
				get("workspaces").
				then().
				assertThat().
				statusCode(200).extract().response().path("workspaces[0].name");
			System.out.println("workspace name->"+name);
			assertThat(name,equalTo("Workspace1")); // hamcrest ki place pe TestNG ke Assert bhi use kar sakte hai.
	}


}
