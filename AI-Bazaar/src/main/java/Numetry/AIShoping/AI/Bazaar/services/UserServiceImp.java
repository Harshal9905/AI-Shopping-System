package Numetry.AIShoping.AI.Bazaar.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import Numetry.AIShoping.AI.Bazaar.entity.User;
import Numetry.AIShoping.AI.Bazaar.repository.UserRepository;

@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public ResponseEntity<User> saveUser(User user) {
		try {
			System.out.println(user);
			if (user == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			String hashedPassword = passwordEncoder.encode(user.getPasswordHash());
            user.setPasswordHash(hashedPassword);
            System.out.println(user.getPasswordHash());
            user.setUsername(user.getEmail());
			User savedUser = userRepository.save(user);
			System.out.println(user);
			return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@Override
	public Optional<User> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	
	

}
