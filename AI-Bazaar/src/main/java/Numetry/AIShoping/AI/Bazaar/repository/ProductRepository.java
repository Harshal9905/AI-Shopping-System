package Numetry.AIShoping.AI.Bazaar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Numetry.AIShoping.AI.Bazaar.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	 // Correct method name for finding products by brand ID
    List<Product> findByBrand_BrandId(Long brandId);
    
    // Correct method name for finding products by category ID
    List<Product> findByCategory_CategoryId(Long categoryId); 	
}
