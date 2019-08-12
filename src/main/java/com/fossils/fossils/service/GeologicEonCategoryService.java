package com.fossils.fossils.service;

import java.util.List;

import com.fossils.fossils.entity.GeCategory;

public interface GeologicEonCategoryService {

	GeCategory findById(Long categoryId);
	GeCategory addCategory(GeCategory geologicEonCategory);
	List<GeCategory> getAllCategory();
}
