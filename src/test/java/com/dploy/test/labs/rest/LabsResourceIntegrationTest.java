package com.dploy.test.labs.rest;

import static com.jayway.restassured.RestAssured.expect;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;
import org.springframework.http.HttpStatus;

import com.dploy.test.labs.setup.SetupIntegrationTest;


public class LabsResourceIntegrationTest extends SetupIntegrationTest {

	@Test
	public void shouldGet() throws Exception {
		expect()
			.statusCode(HttpStatus.OK.value())
				.when().get("/api/labs");
	}
	
	@Test
	public void shouldGetById() throws Exception {
		String id = "1";
		given().
        	pathParam("id", id).
        when().
        	get("/api/labs/{id}").
        then().
        	statusCode(200).body("id", equalTo(id));
	}
	
	@Test
	public void shouldGetNothingById() throws Exception {
		given().
			pathParam("id", "unknown").
		when().
			get("/api/labs/{id}").
		then().
			statusCode(404);
	}
}
