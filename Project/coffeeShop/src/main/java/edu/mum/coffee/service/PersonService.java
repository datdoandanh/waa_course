package edu.mum.coffee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.Role;
import edu.mum.coffee.domain.User;
import edu.mum.coffee.repository.PersonRepository;
import edu.mum.coffee.repository.RoleRepository;
import edu.mum.coffee.repository.UserRepository;

@Service
@Transactional
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	public Person savePerson(Person person) {
		List<User> users = userRepository.findByEmailAllIgnoreCase(person.getEmail());
		User user = null;
		if (users.size() == 1) {
			user = users.get(0);
		} else {
			user = new User();
		}
		Role role = roleRepository.findOne(person.getRole()); 
		user.setEmail(person.getEmail());
		user.setPassword(person.getPassword());
		user.addRole(role);
		user.setEnabled(person.isEnable());
		userRepository.save(user);
		
		return personRepository.save(person);
	}

	public List<Person> findByEmail(String email) {
		return personRepository.findByEmail(email);
	}

	public List<Person> getAllPerson() {
		return personRepository.findByEnable(true);
	}
	public Person findById(Long id) {
		return personRepository.findOne(id);
	}

	public void removePerson(Person person) {
		List<User> users = userRepository.findByEmailAllIgnoreCase(person.getEmail());
		User user = null;
		if (users.size() == 1) {
			user = users.get(0);
		} else {
			user = new User();
		}
		user.clearRoles();
		person.setAddress(null);
		userRepository.delete(user);
		personRepository.delete(person);
	}

}
