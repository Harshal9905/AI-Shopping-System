package Numetry.AIShoping.AI.Bazaar.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Numetry.AIShoping.AI.Bazaar.entity.Category;
import Numetry.AIShoping.AI.Bazaar.entity.Product;
import Numetry.AIShoping.AI.Bazaar.services.CategoryService;
import Numetry.AIShoping.AI.Bazaar.services.ProductService;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Product>> getAllProduct(){
		
		System.out.println("InController");
		System.out.println(productService.getAllProduct());
		return productService.getAllProduct();
	}
	@GetMapping("/getAllByBrandId/{brandId}")
	public ResponseEntity<List<Product>> getAllByBrandId(@PathVariable Long brandId){
		return productService.getByBrand(brandId);
		
	}
	@GetMapping("/getAllByCategoryId/{categoryId}")
	public ResponseEntity<List<Product>> getAllByCategory(@PathVariable Long categoryId){
		
		return productService.getByCategory(categoryId);
		
	}
	@GetMapping("/getAllById/{productId}")
	public ResponseEntity<Product> getAllProductById(@PathVariable Long productId){
		return productService.getAllByProductId(productId);
		
	}
	@GetMapping
	public ResponseEntity<List<Product>> searchProducts(@RequestParam(required = false, defaultValue = "") String search) {
	    List<Product> products = productService.searchProducts(search);
	    return ResponseEntity.ok(products);
	}
	
	@GetMapping("/getAllByTagsName/{selectedValue}")
	public ResponseEntity<List<Product>> getByTags(@PathVariable String selectedValue){
		System.out.println("tags to product");
	    ResponseEntity<List<Category>> categories = categoryService.getByTagsName(selectedValue);
	    System.err.println(categories);
	    List<Product> products = new ArrayList<>();
	    if (categories != null && categories.getBody() != null) {
	        for (Category category : categories.getBody()) {
	            ResponseEntity<List<Product>> productsResponse = productService.getByCategory(category.getCategoryId());
	            System.err.println(productsResponse);
	            if (productsResponse != null && productsResponse.getBody() != null) {
	                products.addAll(productsResponse.getBody());
	                System.out.println(products);
	            }
	        }
	    }
	    System.out.println(products);
	    return ResponseEntity.ok(products);
	}

}
