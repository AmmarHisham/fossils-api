package com.fossils.fossils.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fossils.fossils.entity.GeSubCategoryPost;
import com.fossils.fossils.repository.GESubCategoryPostRepository;
import com.fossils.fossils.repository.GESubCategoryRepository;

@RestController
public class GESubCategoryPostController {

	@Autowired
	GESubCategoryRepository geSubCategoryRepository;

	@Autowired
	GESubCategoryPostRepository geSubCategoryPostRepository;

	@Autowired
	ModelMapper modelMapper;

	@PostMapping(value="/api/subCategoryPost/{sub_category_id}")
	public GeSubCategoryPost addSubCategoryPost(@PathVariable(value = "sub_category_id") Long subCategoryId,
			@RequestBody GeSubCategoryPost  geSubCategoryPost)
			throws Exception {

		return geSubCategoryRepository.findById(subCategoryId).map(subCategory -> {			
			geSubCategoryPost.setGeSubCategory(subCategory);
			return geSubCategoryPostRepository.save(geSubCategoryPost);
		}).orElseThrow(() -> new Exception("sub_category_id " + subCategoryId + " not found"));
	}

	@GetMapping("/api/subCategoryPost/getAllSubCategoryPosts")
	public List<GeSubCategoryPost> getAllSubCategoryPost() {
		List<GeSubCategoryPost> gESubCategoryPosts = geSubCategoryPostRepository.findAll();
		return gESubCategoryPosts;
	}

	@PutMapping("/api/subCategoryPost/update")
	public GeSubCategoryPost createOrUpdateCategory(@RequestBody GeSubCategoryPost geSubCategoryPost) {
		Optional<GeSubCategoryPost> category = geSubCategoryPostRepository.findById(geSubCategoryPost.getId());

		if (category.isPresent()) {
			GeSubCategoryPost newEntity = category.get();
			newEntity.setPostDescription(geSubCategoryPost.getPostDescription());
			newEntity.setPostYear(geSubCategoryPost.getPostYear());
			newEntity.setPostImageUrl(geSubCategoryPost.getPostImageUrl());
			newEntity = geSubCategoryPostRepository.save(newEntity);

			return newEntity;
		} else {
			geSubCategoryPost = geSubCategoryPostRepository.save(geSubCategoryPost);
			return geSubCategoryPost;
		}
	}

	@DeleteMapping("/api/subCategoryPost/delete/{subCategory_id}")
	public void deleteCategoryById(@PathVariable(value = "subCategory_id") Long category_id) {
		Optional<GeSubCategoryPost> subCategoryPost = geSubCategoryPostRepository.findById(category_id);
		if (subCategoryPost.isPresent()) {
			geSubCategoryPostRepository.deleteById(category_id);
		} else {

		}
	}

}
