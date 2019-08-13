package com.fossils.fossils.dto;

import java.io.Serializable;
import java.util.List;

import com.fossils.fossils.entity.GeSubCategory;

public class GECategoryDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private Long fromYear;
	private Long toYear;
	private String scaleUnit;
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

	public Long getFromYear() {
		return fromYear;
	}

	public void setFromYear(Long fromYear) {
		this.fromYear = fromYear;
	}

	public Long getToYear() {
		return toYear;
	}

	public void setToYear(Long toYear) {
		this.toYear = toYear;
	}

	public String getScaleUnit() {
		return scaleUnit;
	}

	public void setScaleUnit(String scaleUnit) {
		this.scaleUnit = scaleUnit;
	}



}
