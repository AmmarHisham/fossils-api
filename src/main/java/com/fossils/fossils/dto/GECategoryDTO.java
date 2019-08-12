package com.fossils.fossils.dto;

import java.util.List;

import com.fossils.fossils.entity.GeSubCategory;

public class GECategoryDTO {

	private Long id;
	private String name;
	private Long scaleUnit;
	private List<GeSubCategory> geSubCategories;

	public List<GeSubCategory> getGeSubCategories() {
		return geSubCategories;
	}

	public void setGeSubCategories(List<GeSubCategory> geSubCategories) {
		this.geSubCategories = geSubCategories;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getScaleUnit() {
		return scaleUnit;
	}

	public void setScaleUnit(Long scaleUnit) {
		this.scaleUnit = scaleUnit;
	}

}
