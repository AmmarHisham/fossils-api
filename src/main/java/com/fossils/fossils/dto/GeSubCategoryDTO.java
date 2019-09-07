package com.fossils.fossils.dto;

import java.io.Serializable;
import java.util.List;

public class GeSubCategoryDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private Long fromAge;
	private Long toAge;
	private List<GeSubCategoryDivisionDTO> child;

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

	public List<GeSubCategoryDivisionDTO> getChild() {
		return child;
	}

	public void setChild(List<GeSubCategoryDivisionDTO> child) {
		this.child = child;
	}

}
