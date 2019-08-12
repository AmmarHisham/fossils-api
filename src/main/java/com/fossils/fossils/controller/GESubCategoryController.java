package com.fossils.fossils.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fossils.fossils.dto.GESubCategoryDTO;
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

	@PostMapping("/api/category/{category_id}/addSubCategory")
	public GeSubCategory addSubCategory(@PathVariable(value = "category_id") Long categoryId,
			@RequestBody GeSubCategory geologicEonSubCategory) throws Exception {
		return geologicEonCategoryRepository.findById(categoryId).map(category -> {
			geologicEonSubCategory.setGeCat(category);
			return geologicEonSubCategoryRepository.save(geologicEonSubCategory);
		}).orElseThrow(() -> new Exception("categoryId " + categoryId + " not found"));
	}

	@GetMapping("/api/category/getAllSubCategory")
	public List<GeSubCategory> getAllSubCategory() {
		List<GeSubCategory> gESubCategories =  geologicEonSubCategoryRepository.findAll();
	
		return gESubCategories;
		//return gESubCategories.stream().map(category -> convertToDto(category)).collect(Collectors.toList());
	}

	private GESubCategoryDTO convertToDto(GeSubCategory gESubCategory) {
		GESubCategoryDTO gESubCategoryDTO = modelMapper.map(gESubCategory, GESubCategoryDTO.class);
		return gESubCategoryDTO;
	}

	
}
