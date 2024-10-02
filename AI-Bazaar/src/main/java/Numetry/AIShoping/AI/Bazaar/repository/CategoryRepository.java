package Numetry.AIShoping.AI.Bazaar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Numetry.AIShoping.AI.Bazaar.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

	List<Category> findByTags_TagId(Long tagsId);

	List<Category> findByTags_tagsName(String tagsId);
	
}
