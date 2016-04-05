
package edu.mum.eselling.service;

import java.util.List;

import edu.mum.eselling.domain.Category;


public interface CategoryService {
	
				
		public List<Category> findAll();
		
		public Category  saveCategory(Category category);
		
		public Category find(Long catId);
		
		
		   
	
}


