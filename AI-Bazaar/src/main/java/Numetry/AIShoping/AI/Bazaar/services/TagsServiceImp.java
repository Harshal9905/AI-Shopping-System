package Numetry.AIShoping.AI.Bazaar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import Numetry.AIShoping.AI.Bazaar.entity.Tags;
import Numetry.AIShoping.AI.Bazaar.repository.TagsRepository;

@Service
public class TagsServiceImp implements TagsService{
	
	@Autowired
	private TagsRepository tagsRepository;

	@Override
	public ResponseEntity<List<Tags>> getAll() {
		try {
			List<Tags> tags = tagsRepository.findAll();
			System.out.println(tags);
			if(tags.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tags, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
