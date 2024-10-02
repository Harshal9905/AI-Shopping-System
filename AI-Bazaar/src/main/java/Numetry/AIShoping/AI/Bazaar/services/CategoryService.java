package Numetry.AIShoping.AI.Bazaar.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import Numetry.AIShoping.AI.Bazaar.entity.Category;

public interface CategoryService {

	public ResponseEntity<List<Category>> getAll();
	
	public ResponseEntity<Category> getById(Long categoryID);
	
	public ResponseEntity<List<Category>> getByTagsName(String tagsName);
}
