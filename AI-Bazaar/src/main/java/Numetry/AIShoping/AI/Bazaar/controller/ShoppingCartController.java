package Numetry.AIShoping.AI.Bazaar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Numetry.AIShoping.AI.Bazaar.entity.ShoppingCart;
import Numetry.AIShoping.AI.Bazaar.services.ShoppingCartService;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/shoppingCart")

public class ShoppingCartController {
	
	
	
	@PostMapping("/add")
	public ResponseEntity<ShoppingCart> addProduct(){
		return null;
		
	}
}
