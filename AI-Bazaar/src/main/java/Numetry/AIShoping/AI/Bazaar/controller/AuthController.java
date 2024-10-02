package Numetry.AIShoping.AI.Bazaar.controller;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Numetry.AIShoping.AI.Bazaar.entity.LoginRequest;
import Numetry.AIShoping.AI.Bazaar.entity.User;
import Numetry.AIShoping.AI.Bazaar.services.EmailService;

import Numetry.AIShoping.AI.Bazaar.services.OtpServiceImp;
import Numetry.AIShoping.AI.Bazaar.services.UserServiceImp;

@RestController
 
@CrossOrigin(origins = "http://127.0.0.1:5500")

@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private UserServiceImp userService;
	
	@Autowired
	private OtpServiceImp otpService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
    private BCryptPasswordEncoder encoder; // Define BCryptPasswordEncoder as a bean
	
	//Otp validation to use in register user
	boolean isOtpValid = false;
	
	private Map<String, Integer> otpStorage = new ConcurrentHashMap<>();
	
	 @PostMapping("/send-otp")
	 public ResponseEntity<?> sendOtp(@RequestBody Map<String, String> request) {
		 System.out.println("Check");
	     String email = request.get("email");
	        
	     // Generate OTP and send it via email
	     int otp = otpService.generateOtp(email);
	     otpStorage.put(email, otp); // Store OTP temporarily
	     emailService.sendOtpMail(email, otp);

	     return ResponseEntity.ok(Map.of("success", true, "message", "OTP sent to your email"));
	 }
	 
	 
	 @PostMapping("/verify-otp")
	 public ResponseEntity<?> verifyOtp(@RequestBody Map<String, String> request) {
	     String email = request.get("email");
	     int otp = Integer.parseInt(request.get("otp"));

	     isOtpValid = otpService.verifyOtp(email, otp);
	     if (isOtpValid) {
	    	 System.out.println("OTP Verified");
	         return ResponseEntity.ok(Map.of("success", true, "message", "OTP verified!"));
	     } else {
	         return ResponseEntity.badRequest().body(Map.of("success", false, "message", "Invalid OTP"));
	     }
	 }
	 
	 @PostMapping("/register")
	 public ResponseEntity<?> registerUser(@RequestBody User user) {
		 System.out.println(user.getPasswordHash());
		 BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		 String encodedPassword = encoder.encode(user.getPasswordHash());

	        // Verify OTP before registering user
		 
	        if (isOtpValid) {
	        	System.out.println("isOtpValid");
	            // Save the user after OTP verification
	        	System.out.println(user);
	            ResponseEntity<User> registeredUser = userService.saveUser(user);
	            return ResponseEntity.ok(Map.of("message", "User registered successfully"));
	        } else {
	            return ResponseEntity.badRequest().body(Map.of("error", "Invalid OTP"));
	        }
	    }
	 
	 
	 @PostMapping("/login")
	 public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
		 System.out.println("In Login");
	     // Fetch the user by email
	     Optional<User> userOptional = userService.findByEmail(loginRequest.getEmail());

	     if (userOptional.isPresent()) {
	         User user = userOptional.get();
	         BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	         System.out.println(loginRequest.getPassword());
	         System.out.println(user.getPasswordHash());
	         System.out.println(encoder.matches(loginRequest.getPassword(), user.getPasswordHash()));

	         // Check if the password matches
	         if (encoder.matches(loginRequest.getPassword(), user.getPasswordHash())) {
	             // Successful login
	             return ResponseEntity.ok(Map.of("message", "Login successful", "user", user));
	         } else {
	             // Invalid password
	             return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Invalid credentials"));
	         }
	     } else {
	         // User not found
	         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "User not found"));
	     }
	 }

}
