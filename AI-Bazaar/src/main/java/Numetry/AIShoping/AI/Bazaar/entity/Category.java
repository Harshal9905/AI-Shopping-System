package Numetry.AIShoping.AI.Bazaar.entity;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long categoryId;

	 private String categoryName;

	 @OneToMany(mappedBy = "category")
	 @JsonIgnore
	 private Set<Product> products;
	 
	 @ManyToMany
	 @JoinTable(
		        name = "category_tags",
		        joinColumns = @JoinColumn(name = "category_id"),
		        inverseJoinColumns = @JoinColumn(name = "tag_id")
		    )
	 @JsonIgnore
	 private List<Tags> tags;

	public List<Tags> getTags() {
		return tags;
	}

	public void setTags(List<Tags> tags) {
		this.tags = tags;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	 
}
