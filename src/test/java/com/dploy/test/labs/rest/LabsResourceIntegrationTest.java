package com.dploy.test.labs.rest;

import static com.jayway.restassured.RestAssured.expect;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import br.com.six2six.fixturefactory.Fixture;

import com.dploy.test.labs.domain.Lab;
import com.dploy.test.labs.fixture.templates.LabTemplate;
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
        	statusCode(HttpStatus.OK.value()).body("id", equalTo(id));
	}
	
	@Test
	public void shouldGetNothingById() throws Exception {
		given().
			pathParam("id", "unknown").
		when().
			get("/api/labs/{id}").
		then().
			statusCode(HttpStatus.NOT_FOUND.value());
	}
	
	@Test
	public void shouldAddLab() throws Exception {
		Lab lab = Fixture.from(Lab.class).gimme(LabTemplate.COMPLETE);
		given()
			.contentType(MediaType.APPLICATION_JSON_VALUE)
			.accept(MediaType.APPLICATION_JSON_VALUE)
			.body(lab)
		.when()
			.post("/api/labs")
		.then()
			.statusCode(HttpStatus.CREATED.value())
		.assertThat()
			.body("id", equalTo(lab.getId()))
			.body("firstName", equalTo(lab.getFirstName()))
			.body("lastName", equalTo(lab.getLastName()));
	}	
}
