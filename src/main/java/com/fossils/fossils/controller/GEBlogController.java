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

import com.fossils.fossils.entity.GeBlog;
import com.fossils.fossils.repository.GEBlogRepository;

@RestController
public class GEBlogController {

	@Autowired
	GEBlogRepository geBlogRepository;

	@Autowired
	ModelMapper modelMapper;

	@PostMapping(value = "/api/blog")
	public GeBlog addSubCategoryDivItem(@RequestBody GeBlog geBlog) throws Exception {
			return geBlogRepository.save(geBlog);
	}

	@GetMapping("/api/blog/getAllBlogs")
	public List<GeBlog> getAllSubCategoryDivItem() {
		List<GeBlog> gESubCategoryPosts = geBlogRepository.findAll();
		return gESubCategoryPosts;
	}

	@PutMapping("/api/blog/update")
	public GeBlog createOrUpdateCategory(@RequestBody GeBlog geBlog) {
		Optional<GeBlog> category = geBlogRepository.findById(geBlog.getId());

		if (category.isPresent()) {
			GeBlog newEntity = category.get();
			newEntity.setBlogTitle(geBlog.getBlogTitle());
			newEntity.setBlogDescription(geBlog.getBlogDescription());
			newEntity.setBlogImageUrl(geBlog.getBlogImageUrl());
			newEntity = geBlogRepository.save(newEntity);

			return newEntity;
		} else {
			geBlog = geBlogRepository.save(geBlog);
			return geBlog;
		}
	}

	@DeleteMapping("/api/blog/delete/{blog_id}")
	public void deletesubCategoryDivItemById(@PathVariable(value = "blog_id") Long blog_id) {
		Optional<GeBlog> geBlog = geBlogRepository.findById(blog_id);
		System.out.println("geBlog : "+geBlog);		
		if (geBlog.isPresent()) {
			geBlogRepository.deleteById(blog_id);
		} else {

		}
	}

}
