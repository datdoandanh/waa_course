package edu.mum.coffee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.coffee.domain.Role;

@Repository
public interface RoleRepository  extends JpaRepository<Role, Integer>{
}
