package Numetry.AIShoping.AI.Bazaar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Numetry.AIShoping.AI.Bazaar.entity.Address;
import Numetry.AIShoping.AI.Bazaar.entity.User;
import Numetry.AIShoping.AI.Bazaar.services.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class AddressController {
	
	@Autowired
	private UserService userService;
	
//	@PostMapping("/saveAddress")
//	public ResponseEntity<?> saveAddres(@RequestBody Address addressDto, @AuthenticationPrincipal User user){
//		try {
//            Address address = new Address();
//            address.setAddressline(addressDto.getAddressline());
//            address.setState(addressDto.getState());
//            address.setCity(addressDto.getCity());
//            address.setPincode(addressDto.getPincode());
//            address.setUser(user);
//
//         // Add address to user's address list
//            user.addAddress(address);
//
//            // Save the updated user with the new address
//            userService.saveUser(user);
//
//            return ResponseEntity.ok().body("Address saved successfully");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving address");
//        }
		
//	}
}
