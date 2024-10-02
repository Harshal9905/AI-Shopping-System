package Numetry.AIShoping.AI.Bazaar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Numetry.AIShoping.AI.Bazaar.entity.Tags;

@Repository
public interface TagsRepository extends JpaRepository<Tags, Long>{

}
