package Numetry.AIShoping.AI.Bazaar.services;

import org.springframework.http.ResponseEntity;

import Numetry.AIShoping.AI.Bazaar.entity.ShoppingCart;

public interface ShoppingCartService {
	
	public ResponseEntity<ShoppingCart> addProductToCart(Long productId, Integer quantity, Long userId);
	
	public ResponseEntity<ShoppingCart> removeProductFromCart(Long productId, Integer quantity, Long userId);
}
