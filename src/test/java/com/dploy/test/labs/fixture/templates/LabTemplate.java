package com.dploy.test.labs.fixture.templates;

import java.util.UUID;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import com.dploy.test.labs.domain.Lab;

public class LabTemplate implements TemplateLoader {

	public static final String COMPLETE = "complete";
	
	public void load() {
		Fixture.of(Lab.class).addTemplate(COMPLETE, new Rule(){{
		    add("id", UUID.randomUUID().toString());
		    add("firstName", firstName());
		    add("lastName", lastName());
		    add("birth", instant("18 years ago"));
		}});
	}	
}
