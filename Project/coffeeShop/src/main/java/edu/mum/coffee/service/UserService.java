package edu.mum.coffee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.coffee.domain.User;
import edu.mum.coffee.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User save(User user) {
		return userRepository.save(user);
	}
	
	public User findByEmail(String email) {
		List<User> users = userRepository.findByEmailAllIgnoreCase(email);
		if (users.size() == 1) {
			return users.get(0);
		}
		return null;
	}

}
