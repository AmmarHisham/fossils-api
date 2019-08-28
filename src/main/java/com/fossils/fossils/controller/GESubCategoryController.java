package com.fossils.fossils.controller;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fossils.fossils.entity.GeSubCategory;
import com.fossils.fossils.repository.GECategoryRepository;
import com.fossils.fossils.repository.GESubCategoryRepository;

@RestController
public class GESubCategoryController {

	@Autowired
	GECategoryRepository geologicEonCategoryRepository;

	@Autowired
	GESubCategoryRepository geologicEonSubCategoryRepository;
	
	@Autowired
	ModelMapper modelMapper;

	@PostMapping("/api/subCategory/{category_id}/addSubCategory")
	public GeSubCategory addSubCategory(@PathVariable(value = "category_id") Long categoryId,
			@RequestBody GeSubCategory geologicEonSubCategory) throws Exception {
		return geologicEonCategoryRepository.findById(categoryId).map(category -> {
			geologicEonSubCategory.setGeCat(category);
			return geologicEonSubCategoryRepository.save(geologicEonSubCategory);
		}).orElseThrow(() -> new Exception("categoryId " + categoryId + " not found"));
	}

	@GetMapping("/api/subCategory/getAllSubCategory")
	public List<GeSubCategory> getAllSubCategory() {
		List<GeSubCategory> gESubCategories =  geologicEonSubCategoryRepository.findAll();
		return gESubCategories;
	}

	
	@PutMapping("/api/subCategory/update")
	public GeSubCategory createOrUpdateCategory(@RequestBody GeSubCategory geSubCategory) {
		Optional<GeSubCategory> category = geologicEonSubCategoryRepository.findById(geSubCategory.getId());

		if (category.isPresent()) {
			GeSubCategory newEntity = category.get();
			newEntity.setName(geSubCategory.getName());			
			newEntity = geologicEonSubCategoryRepository.save(newEntity);

			return newEntity;
		} else {
			geSubCategory = geologicEonSubCategoryRepository.save(geSubCategory);

			return geSubCategory;
		}
	}

	@DeleteMapping("/api/subCategory/delete/{subCategory_id}")
	public void deleteCategoryById(@PathVariable(value = "subCategory_id") Long category_id) {
		Optional<GeSubCategory> subCategory = geologicEonSubCategoryRepository.findById(category_id);
		if (subCategory.isPresent()) {
			geologicEonSubCategoryRepository.deleteById(category_id);
		} else {

		}
	}


	
}
