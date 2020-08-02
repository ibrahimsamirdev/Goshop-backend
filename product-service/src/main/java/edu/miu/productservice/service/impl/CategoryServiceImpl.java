package edu.miu.productservice.service.impl;

import edu.miu.productservice.repository.CategoryRepository;
import edu.miu.productservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
    CategoryRepository categoryRepository;

}
