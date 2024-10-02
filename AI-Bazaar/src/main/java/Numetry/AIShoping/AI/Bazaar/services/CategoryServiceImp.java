package Numetry.AIShoping.AI.Bazaar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import Numetry.AIShoping.AI.Bazaar.entity.Category;
import Numetry.AIShoping.AI.Bazaar.repository.CategoryRepository;


@Service
public class CategoryServiceImp implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public ResponseEntity<List<Category>> getAll() {
		try {
			List<Category> categorys = categoryRepository.findAll();
			System.out.println(categorys);
			if(categorys.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(categorys, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@Override
	public ResponseEntity<Category> getById(Long categoryId) {
		try {
			Optional<Category> category = categoryRepository.findById(categoryId);
			if(category.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(category.get(), HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@Override
	public ResponseEntity<List<Category>> getByTagsName(String tagsName) {
		try {
			List<Category> categorys = categoryRepository.findByTags_tagsName(tagsName);
			if(categorys.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(categorys, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
