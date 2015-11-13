package com.dploy.test.labs.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dploy.test.labs.domain.Lab;

@RestController
@RequestMapping(value = "/api")
public class LabsResource {

    @RequestMapping(value = "/labs",
    		method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> integrations() {
    	return new ResponseEntity<List<Lab>>(Arrays.asList(new Lab()), HttpStatus.OK);
    }
    
}