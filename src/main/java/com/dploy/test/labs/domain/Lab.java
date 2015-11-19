package com.dploy.test.labs.domain;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;


@XmlRootElement
@JsonSerialize(include = Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Lab implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private String firstName;
	
	private String lastName;
	
	private Date birth;
	
	public Lab() {}
	
	public Lab(String id, String firstName, String lastName, Date birth) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birth = birth;
	}

	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public Date getBirth() {
		return birth;
	}
}
