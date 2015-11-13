package com.dploy.test.labs.setup;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

import com.dploy.test.labs.App;
import com.jayway.restassured.RestAssured;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebIntegrationTest
public abstract class SetupIntegrationTest {
	
	@BeforeClass
	public static void setUp() {
		RestAssured.baseURI = "http://localhost:8080";
		FixtureFactoryLoader.loadTemplates("com.dploy.test.labs.fixture.templates");
	}
}
