package com.test.one;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Video53 {
	
	@Test
	public void validateResponseCode200()
	{
		// Here we are checking the status code jo response se ayega. 
		//so we are checking status code 200 which is actually returning from response
		//assertThat() method use karege status code ko validate karne ke liye
		given().
		baseUri("https://api.getpostman.com/").
		header("X-API-Key","PMAK-60b258969190c80034a17957-fae158d07a8145f9478adc930a616bd2c0").
		when().get("workspaces").then().assertThat().statusCode(200);
	}
	
	@Test
	public void validateResponsecode201()
	{
		given().
		baseUri("https://api.getpostman.com/").
		header("X-API-Key","PMAK-60b258969190c80034a17957-fae158d07a8145f9478adc930a616bd2c0").
		when().get("workspaces").then().assertThat().statusCode(201);  // Here we are expecting 201 but it returns 200 so ye test case fail hoga.
	}
	
	@Test
	public void responseBodyInLOgs()
	{
		given().
		baseUri("https://api.getpostman.com/").
		header("X-API-Key","PMAK-60b258969190c80034a17957-fae158d07a8145f9478adc930a616bd2c0").
		when().get("workspaces").then().log().all().assertThat().statusCode(200);
		/*
		 * {
    "workspaces": [
        {
            "id": "13f38f61-151a-4852-9b50-9aa5d2a56b7c",
            "name": "Workspace1",
            "type": "personal"
        },
        {
            "id": "569cb9ea-2d47-4518-8ee6-415cc0a52f3a",
            "name": "My Workspace",
            "type": "personal"
        },
        {
            "id": "dd876a8a-9d7a-48a1-821f-80a5ac216944",
            "name": "testAPIWorkSpace",
            "type": "personal"
        }
    ]
}
		 * */
	}
}
