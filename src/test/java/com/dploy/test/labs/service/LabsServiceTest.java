package com.dploy.test.labs.service;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.util.reflection.Whitebox;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.slf4j.Logger;

@PrepareForTest(LabsService.class)
public class LabsServiceTest {

	private LabsService labsService;
	
	private Logger mockLogger;
	
	@Before
	public void before() throws Exception {
		MockitoAnnotations.initMocks(this);
		labsService = new LabsService();
		mockLogger = PowerMockito.mock(Logger.class);
	    Whitebox.setInternalState(labsService, "log", mockLogger);
	}
	
	@Test
	public void shouldLogWhenGet() throws Exception {
	    labsService.get();
	    verify(mockLogger).info(Mockito.eq("Getting labs"));
	}
	
}
