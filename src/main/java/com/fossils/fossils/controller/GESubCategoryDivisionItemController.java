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

import com.fossils.fossils.entity.GeSubCategoryDivisionItem;
import com.fossils.fossils.repository.GESubCategoryDivisionItemRepository;
import com.fossils.fossils.repository.GESubCategoryDivisionRepository;

@RestController
public class GESubCategoryDivisionItemController {

	@Autowired
	GESubCategoryDivisionRepository geSubCategoryDivisionRepository;

	@Autowired
	GESubCategoryDivisionItemRepository geSubCategoryDivisionItemRepository;

	@Autowired
	ModelMapper modelMapper;

	@PostMapping(value = "/api/subCategoryDivItem/{sub_category_div_id}")
	public GeSubCategoryDivisionItem addSubCategoryDivItem(@PathVariable(value = "sub_category_div_id") Long subCategoryDivId,
			@RequestBody GeSubCategoryDivisionItem geSubCategoryDivItem) throws Exception {

		return geSubCategoryDivisionRepository.findById(subCategoryDivId).map(subCategoryDiv -> {
			geSubCategoryDivItem.setGeSubCategoryDivision(subCategoryDiv);
			return geSubCategoryDivisionItemRepository.save(geSubCategoryDivItem);
		}).orElseThrow(() -> new Exception("sub_category_id " + subCategoryDivId + " not found"));
	}

	@GetMapping("/api/subCategoryDivItem/getAllItems")
	public List<GeSubCategoryDivisionItem> getAllSubCategoryDivItem() {
		List<GeSubCategoryDivisionItem> gESubCategoryPosts = geSubCategoryDivisionItemRepository.findAll();
		return gESubCategoryPosts;
	}

	@PutMapping("/api/subCategoryDivItem/update")
	public GeSubCategoryDivisionItem createOrUpdateCategory(@RequestBody GeSubCategoryDivisionItem geSubCategoryDivItem) {
		Optional<GeSubCategoryDivisionItem> category = geSubCategoryDivisionItemRepository.findById(geSubCategoryDivItem.getId());

		if (category.isPresent()) {
			GeSubCategoryDivisionItem newEntity = category.get();
			newEntity.setItemDescription(geSubCategoryDivItem.getItemDescription());
			newEntity.setItemAge(geSubCategoryDivItem.getItemAge());
			newEntity.setItemImageUrl(geSubCategoryDivItem.getItemImageUrl());
			newEntity = geSubCategoryDivisionItemRepository.save(newEntity);

			return newEntity;
		} else {
			geSubCategoryDivItem = geSubCategoryDivisionItemRepository.save(geSubCategoryDivItem);
			return geSubCategoryDivItem;
		}
	}

	@DeleteMapping("/api/subCategoryDivItem/delete/{subCategoryDiv_item_id}")
	public void deletesubCategoryDivItemById(@PathVariable(value = "subCategoryDiv_item_id") Long subCategoryDivItemID) {
		Optional<GeSubCategoryDivisionItem> geSubCategoryDivisionItem = geSubCategoryDivisionItemRepository.findById(subCategoryDivItemID);
		System.out.println("geSubCategoryDivisionItem : "+geSubCategoryDivisionItem);		
		if (geSubCategoryDivisionItem.isPresent()) {
			geSubCategoryDivisionItemRepository.deleteById(subCategoryDivItemID);
		} else {

		}
	}

}
