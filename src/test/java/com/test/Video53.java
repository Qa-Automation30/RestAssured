package com.test;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Video53 {
	
	// Is wale video me sirf Status code assert karywaya hai.
	
	@Test
	public void validateStaus_code()
	{
		// Isme log().all() wala method nai likha hai to resposne body nai ayegai. 
		given().baseUri("https://api.getpostman.com/").
		header("X-API-Key","PMAK-60b258969190c80034a17957-fae158d07a8145f9478adc930a616bd2c0").
		when().get("workspaces").
		then().assertThat().statusCode(200);
	}
	
	@Test
	public void validateStatus_Code()
	{
		given().
		baseUri("https://api.getpostman.com/").
		header("X-API-Key","PMAK-60b258969190c80034a17957-fae158d07a8145f9478adc930a616bd2c0").
		when().get("workspaces").
		then().log().all().assertThat().statusCode(200);  // Is line me maine log().all likhha hai jo pura response print karega body ka.
	}
	@Test
	public void validateStaus_code_failed()
	{
		//Isme deliberately 201 paas kiya hai check karne ke liye ki fail ho raha hai ya nai
		given().baseUri("https://api.getpostman.com/").
		header("X-API-Key","PMAK-60b258969190c80034a17957-fae158d07a8145f9478adc930a616bd2c0").
		when().get("workspaces").
		then().assertThat().statusCode(201);
	}

}
