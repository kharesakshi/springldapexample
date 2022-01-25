package com.example.SpringLDAPExample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringLDAPExample.entity.Person;
import com.example.SpringLDAPExample.repository.PeopleRepository;
import com.example.SpringLDAPExample.service.PersonService;

@RestController
public class LDAPController {
	
	@Autowired
	private PeopleRepository peopleRepository;
	
	@GetMapping("/get-users")
    public ResponseEntity<List<Person>> getLdapUsers() {
        return new ResponseEntity<List<Person>>(peopleRepository.getAllPersons(),HttpStatus.OK);
    }

}
