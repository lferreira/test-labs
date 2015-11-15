package com.dploy.test.labs.rest;

import static com.jayway.restassured.RestAssured.expect;

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
	
}
