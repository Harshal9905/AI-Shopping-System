package Numetry.AIShoping.AI.Bazaar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import Numetry.AIShoping.AI.Bazaar.entity.Tags;
import Numetry.AIShoping.AI.Bazaar.services.TagsService;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/tags")
public class TagsController {
	
	@Autowired
	private TagsService tagsService;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Tags>> getAll(){
		System.out.println("tagsController");
		return tagsService.getAll();
	}
}
