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

import com.fossils.fossils.dto.GESubCategoryPostDTO;
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

	@PostMapping("/api/subCategory/{sub_category_id}")
	public GeSubCategoryPost addSubCategoryPost(@PathVariable(value = "sub_category_id") Long subCategoryId,
			@RequestBody GeSubCategoryPost geSubCategoryPost) throws Exception {
		return geSubCategoryRepository.findById(subCategoryId).map(subCategory -> {
			geSubCategoryPost.setGeSubCategory(subCategory);
			return geSubCategoryPostRepository.save(geSubCategoryPost);
		}).orElseThrow(() -> new Exception("sub_category_id " + subCategoryId + " not found"));
	}

	@GetMapping("/api/subCategory/getAllSubCategoryPosts")
	public List<GeSubCategoryPost> getAllSubCategoryPost() {
		List<GeSubCategoryPost> gESubCategoryPosts = geSubCategoryPostRepository.findAll();
		return gESubCategoryPosts;
		// return gESubCategoryPosts.stream().map(post ->
		// convertToDto(post)).collect(Collectors.toList());
	}

	private GESubCategoryPostDTO convertToDto(GeSubCategoryPost gESubCategoryPost) {
		GESubCategoryPostDTO gESubCategoryPostDTO = modelMapper.map(gESubCategoryPost, GESubCategoryPostDTO.class);
		return gESubCategoryPostDTO;
	}

}
