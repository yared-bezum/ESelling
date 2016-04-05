package edu.mum.eselling.serviceImpl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.eselling.domain.Category;
import edu.mum.eselling.repository.CategoryRepository;
import edu.mum.eselling.service.CategoryService;


@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
		
		@Autowired
		CategoryRepository categoryRepository;


		public List<Category> findAll() {
			
			return (List<Category>)categoryRepository.findAll();
		}

		public Category  saveCategory(Category category) {
			return categoryRepository.save(category);
			
		}
		
		public Category find(Long categoryId){
			return categoryRepository.findOne(categoryId);
		}
}



