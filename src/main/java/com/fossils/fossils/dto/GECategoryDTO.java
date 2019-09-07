package com.fossils.fossils.dto;

import java.io.Serializable;
import java.util.List;

public class GECategoryDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private Long fromAge;
	private Long toAge;
	private String bgImageURL;
	private List<GeSubCategoryDTO> child;

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

	public Long getFromAge() {
		return fromAge;
	}

	public void setFromAge(Long fromAge) {
		this.fromAge = fromAge;
	}

	public Long getToAge() {
		return toAge;
	}

	public void setToAge(Long toAge) {
		this.toAge = toAge;
	}

	public String getBgImageURL() {
		return bgImageURL;
	}

	public void setBgImageURL(String bgImageURL) {
		this.bgImageURL = bgImageURL;
	}

	public List<GeSubCategoryDTO> getChild() {
		return child;
	}

	public void setChild(List<GeSubCategoryDTO> child) {
		this.child = child;
	}



}
