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

import com.fossils.fossils.entity.GeSubCategoryDivision;
import com.fossils.fossils.repository.GECategoryRepository;
import com.fossils.fossils.repository.GESubCategoryDivisionRepository;
import com.fossils.fossils.repository.GESubCategoryRepository;

@RestController
public class GESubCategoryDivisionController {

	@Autowired
	GECategoryRepository geologicEonCategoryRepository;

	@Autowired
	GESubCategoryRepository geSubCategoryRepository;
	
	@Autowired
	GESubCategoryDivisionRepository geSubCategoryDivisionRepository;
	
	@Autowired
	ModelMapper modelMapper;

	@PostMapping("/api/subCategoryDiv/{sub_category_id}/addSubCategory")
	public GeSubCategoryDivision addSubCategoryDiv(@PathVariable(value = "sub_category_id") Long subCategoryId,
			@RequestBody GeSubCategoryDivision geSubCategoryDiv) throws Exception {
		return geSubCategoryRepository.findById(subCategoryId).map(subCategory -> {
			geSubCategoryDiv.setGeSubCategory(subCategory);
			return geSubCategoryDivisionRepository.save(geSubCategoryDiv);
		}).orElseThrow(() -> new Exception("categoryId " + subCategoryId + " not found"));
	}

	@GetMapping("/api/subCategoryDiv/getAllSubCategory")
	public List<GeSubCategoryDivision> getAllSubDivCategory() {
		List<GeSubCategoryDivision> gSubCategoriesDiv =  geSubCategoryDivisionRepository.findAll();
		return gSubCategoriesDiv;
	}

	
	@PutMapping("/api/subCategoryDiv/update")
	public GeSubCategoryDivision createOrUpdateSubCategoryDiv(@RequestBody GeSubCategoryDivision geSubCategory) {
		Optional<GeSubCategoryDivision> category = geSubCategoryDivisionRepository.findById(geSubCategory.getId());

		if (category.isPresent()) {
			GeSubCategoryDivision newEntity = category.get();
			newEntity.setName(geSubCategory.getName());			
			newEntity = geSubCategoryDivisionRepository.save(newEntity);

			return newEntity;
		} else {
			geSubCategory = geSubCategoryDivisionRepository.save(geSubCategory);

			return geSubCategory;
		}
	}

	@DeleteMapping("/api/subCategoryDiv/delete/{subCategory_div_id}")
	public void deleteSubCategoryDivById(@PathVariable(value = "subCategory_div_id") Long subCategory_div_id) {
		Optional<GeSubCategoryDivision> SubCategoryDiv = geSubCategoryDivisionRepository.findById(subCategory_div_id);
		if (SubCategoryDiv.isPresent()) {
			geSubCategoryDivisionRepository.deleteById(subCategory_div_id);
		} else {

		}
	}


	
}
