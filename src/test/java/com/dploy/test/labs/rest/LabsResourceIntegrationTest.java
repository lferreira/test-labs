package com.dploy.test.labs.rest;

import static com.jayway.restassured.RestAssured.expect;

import org.junit.Test;

import com.dploy.test.labs.setup.SetupIntegrationTest;


public class LabsResourceIntegrationTest extends SetupIntegrationTest {

	@Test
	public void souldGetIntegrations() throws Exception {
		expect()
			.statusCode(200)
				.when().get("/api/labs");
	}
	
}
