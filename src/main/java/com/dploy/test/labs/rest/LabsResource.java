package com.dploy.test.labs.rest;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
    ResponseEntity<?> labs() {
    	return Optional.ofNullable(mockedList())
    			.map(returned -> new ResponseEntity<>(returned, HttpStatus.OK))
    				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @RequestMapping(value = "/labs/{id}",
    		method = RequestMethod.GET,
    		produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> labsById(@PathVariable String id) {
    	return filter(id)
    			.map(returned -> new ResponseEntity<>(returned, HttpStatus.OK))
    			.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    private Optional<Lab> filter(String id) {
    	return mockedList().stream().filter(lab -> lab.getId().equals(id)).findFirst();
    }
    
    private List<Lab> mockedList() {
    	Lab lab1 = new Lab("1", "Lab" , "One" , new Date());
    	Lab lab2 = new Lab("2", "Lab" , "Two" , new Date());
    	Lab lab3 = new Lab("3", "Lab" , "Three" , new Date());
    	Lab lab4 = new Lab("4", "Lab" , "Four" , new Date());
    	Lab lab5 = new Lab("5", "Lab" , "Five" , new Date());
    	Lab lab6 = new Lab("6", "Lab" , "Six" , new Date());
    	return Arrays.asList(lab1 ,lab2, lab3, lab4, lab5, lab6);
    }
}