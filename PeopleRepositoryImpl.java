package com.example.SpringLDAPExample.repository;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.naming.Name;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.query.LdapQuery;
import org.springframework.stereotype.Service;

import com.example.SpringLDAPExample.entity.Person;

@Service
public class PeopleRepositoryImpl implements PeopleRepository {
	
	@Autowired
	private LdapTemplate ldapTemplate;
	
	@Override
	public List<Person> getAllPersons(){
		List<Person> personNames = ldapTemplate.search(query().where("objectClass").is("person"), new PersonAttributesMapper());
		return personNames;
	}
	
	private class PersonAttributesMapper implements AttributesMapper<Person> {
        public Person mapFromAttributes(Attributes attrs) throws NamingException {
            Person person = new Person();
            person.setUserId(null != attrs.get("uid") ? (String) attrs.get("uid").get() : null);
            person.setFullName((String) attrs.get("cn").get());
            person.setLastName((String) attrs.get("sn").get());
            person.setDescription(null != attrs.get("description") ? (String) attrs.get("description").get() : null);
            return person;
        }
    }

	@Override
	public <S extends Person> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> findAllById(Iterable<Name> names) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Person> findOne(LdapQuery ldapQuery) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Person> findAll(LdapQuery ldapQuery) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Person> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Person> findById(Name id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Name id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Name id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Person entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Name> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Person> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
}
