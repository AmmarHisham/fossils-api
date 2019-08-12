package com.fossils.fossils.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fossils.fossils.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	    User findByUserNameAndPassword(String username, String password);
	}
