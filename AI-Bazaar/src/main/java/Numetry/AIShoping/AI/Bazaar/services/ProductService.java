package Numetry.AIShoping.AI.Bazaar.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import Numetry.AIShoping.AI.Bazaar.entity.Product;


public interface ProductService {
	
	public ResponseEntity<List<Product>> getAllProduct();
	
	public ResponseEntity<List<Product>> getByBrand(Long BrabndId);
	
	public ResponseEntity<List<Product>> getByCategory(Long CategoryId);
	
	public ResponseEntity<Product> getAllByProductId(Long ProductId);
	
	public List<Product> searchProducts(String search);
}
