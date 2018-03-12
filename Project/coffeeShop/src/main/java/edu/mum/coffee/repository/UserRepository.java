package edu.mum.coffee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.coffee.domain.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long>{
	List<User> findByEmailAllIgnoreCase(String email);
}
