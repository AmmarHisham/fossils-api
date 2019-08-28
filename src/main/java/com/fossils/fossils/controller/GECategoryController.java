package com.fossils.fossils.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fossils.fossils.dto.GECategoryDTO;
import com.fossils.fossils.entity.GeCategory;
import com.fossils.fossils.repository.GECategoryRepository;
import com.fossils.fossils.repository.GEPageRepository;
import com.fossils.fossils.service.GeologicEonCategoryService;

@RestController
public class GECategoryController {
	@Autowired
	GeologicEonCategoryService geologicEonCategoryService;

	@Autowired
	GECategoryRepository geologicEonCategoryRepository;
	
	@Autowired
	GEPageRepository gePageRepository;

	@Autowired
	ModelMapper modelMapper;
	
	@PostMapping("/api/category/{page_id}/addCategory")
	public GeCategory addSubCategory(@PathVariable(value = "page_id") Long pageId,
			@RequestBody GeCategory geologicEonCategory) throws Exception {
		return gePageRepository.findById(pageId).map(page -> {
			geologicEonCategory.setGePage(page);
			return geologicEonCategoryService.addCategory(geologicEonCategory);
		}).orElseThrow(() -> new Exception("pageId " + pageId + " not found"));
	}

	@GetMapping("/api/category/result")
	public List<GECategoryDTO> result() {

		List<GeCategory> gESCategories = geologicEonCategoryRepository.findAll();
		return gESCategories.stream().map(category -> convertToDto(category)).collect(Collectors.toList());

	}

	@GetMapping("/api/category/getAllCategory")
	public List<GeCategory> getAllCategory() {

		List<GeCategory> gESCategories = geologicEonCategoryRepository.findAll();
		return gESCategories;
	}

	@PutMapping("/api/category/update")
	public GeCategory createOrUpdateCategory(@RequestBody GeCategory geCategory) {
		Optional<GeCategory> category = geologicEonCategoryRepository.findById(geCategory.getId());

		if (category.isPresent()) {
			GeCategory newEntity = category.get();
			newEntity.setName(geCategory.getName());
			newEntity.setFromAge(geCategory.getFromAge());
			newEntity.setToAge(geCategory.getToAge());

			newEntity = geologicEonCategoryRepository.save(newEntity);

			return newEntity;
		} else {
			geCategory = geologicEonCategoryRepository.save(geCategory);

			return geCategory;
		}
	}

	@DeleteMapping("/api/category/delete/{category_id}")
	public void deleteCategoryById(@PathVariable(value = "category_id") Long category_id) {
		Optional<GeCategory> category = geologicEonCategoryRepository.findById(category_id);
		if (category.isPresent()) {
			geologicEonCategoryRepository.deleteById(category_id);
		} else {

		}
	}

	private GECategoryDTO convertToDto(GeCategory gECategory) {
		GECategoryDTO gECategoryDTO = modelMapper.map(gECategory, GECategoryDTO.class);
		return gECategoryDTO;
	}

}
