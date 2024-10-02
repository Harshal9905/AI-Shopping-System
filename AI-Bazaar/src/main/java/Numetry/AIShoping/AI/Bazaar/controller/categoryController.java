package Numetry.AIShoping.AI.Bazaar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Numetry.AIShoping.AI.Bazaar.entity.Category;
import Numetry.AIShoping.AI.Bazaar.services.CategoryService;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/category")
public class categoryController {
	
	@Autowired
	private CategoryService categoryService; 
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Category>> getAll(){
		System.out.println("CategoryController");
		return categoryService.getAll();
	}
}
