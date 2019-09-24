package shoponline.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoponline.entity.Category;
import shoponline.repository.CategoryRepository;
import shoponline.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> getListCategory() {
		return categoryRepository.getListCategory();
	}

}
