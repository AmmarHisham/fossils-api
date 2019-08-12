package com.fossils.fossils.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fossils.fossils.entity.GeCategory;
import com.fossils.fossils.service.GeologicEonCategoryService;

@RestController
public class GECategoryController {
	@Autowired
	GeologicEonCategoryService geologicEonCategoryService;

	@PostMapping("/api/category/addCategory")
	public GeCategory addCategory(@RequestBody GeCategory geologicEonCategory) {
		return geologicEonCategoryService.addCategory(geologicEonCategory);

	}

	@GetMapping("/api/category/getAllCategory")
	public List<GeCategory> getAllCategory() {
		return geologicEonCategoryService.getAllCategory();
	}

}
