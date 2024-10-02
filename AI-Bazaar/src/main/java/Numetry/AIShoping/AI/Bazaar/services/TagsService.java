package Numetry.AIShoping.AI.Bazaar.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import Numetry.AIShoping.AI.Bazaar.entity.Tags;

public interface TagsService {
	
	public ResponseEntity<List<Tags>> getAll();
}
