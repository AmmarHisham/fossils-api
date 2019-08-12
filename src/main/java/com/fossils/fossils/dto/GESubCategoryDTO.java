package com.fossils.fossils.dto;

public class GESubCategoryDTO {

	private Long id;
	private String name;
	private GECategoryDTO geCat;

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

	public GECategoryDTO getGeCat() {
		return geCat;
	}

	public void setGeCat(GECategoryDTO geCat) {
		this.geCat = geCat;
	}

}
