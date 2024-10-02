package Numetry.AIShoping.AI.Bazaar.services;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import Numetry.AIShoping.AI.Bazaar.entity.User;

public interface UserService {
	public ResponseEntity<User> saveUser(User user);
	
	public Optional<User> findByEmail(String email);
}
