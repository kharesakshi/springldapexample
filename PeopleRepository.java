package com.example.SpringLDAPExample.repository;

import java.util.List;

import org.springframework.data.ldap.repository.LdapRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringLDAPExample.entity.Person;

@Repository
public interface PeopleRepository extends LdapRepository<Person> {
	List<Person> getAllPersons();

}
