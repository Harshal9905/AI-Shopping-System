package Numetry.AIShoping.AI.Bazaar.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import Numetry.AIShoping.AI.Bazaar.entity.Product;
import Numetry.AIShoping.AI.Bazaar.repository.ProductRepository;

@Service
public class ProductServiceImp implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public ResponseEntity<List<Product>> getAllProduct() {
		try {
			System.out.println("In Service");
			List<Product> products = productRepository.findAll();
//			System.out.println(products);
			if(products.isEmpty()) {
				System.out.println("In Service if");
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			System.out.println("out Service if");
			return new ResponseEntity<>(products, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@Override
	public ResponseEntity<List<Product>> getByBrand(Long BrandId) {
		try {
			List<Product> products = productRepository.findByBrand_BrandId(BrandId);
			if(products.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(products, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<List<Product>> getByCategory(Long CategoryId) {
		try {
			System.out.println("in the getByCategory");
			long a = 5;
			List<Product> products = productRepository.findByCategory_CategoryId(CategoryId);
			System.out.println(CategoryId);
			if(products.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(products, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Product> getAllByProductId(Long productId) {
		try {
			Optional<Product> product = productRepository.findById(productId);
			if(product.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(product.get(), HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public List<Product> searchProducts(String search) {
		List<Product> products = productRepository.findAll();
        return products.stream()
            .filter(product -> product.getName().toLowerCase().contains(search.toLowerCase()))
            .collect(Collectors.toList());
		
	}

}
