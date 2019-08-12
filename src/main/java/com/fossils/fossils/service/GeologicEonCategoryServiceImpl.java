package com.fossils.fossils.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fossils.fossils.entity.GeCategory;
import com.fossils.fossils.repository.GECategoryRepository;

@Service
public class GeologicEonCategoryServiceImpl implements GeologicEonCategoryService {

	@Autowired
	GECategoryRepository geologicEonCategoryRepository;

	@Override
	public GeCategory addCategory(GeCategory geologicEonCategory) {
		return geologicEonCategoryRepository.save(geologicEonCategory);
	}

	@Override
	public List<GeCategory> getAllCategory() {
		return geologicEonCategoryRepository.findAll();
	}

	@Override
	public GeCategory findById(Long categoryId) {
		return geologicEonCategoryRepository.findById(categoryId).get();
	}

}
