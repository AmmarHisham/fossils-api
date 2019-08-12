package com.fossils.fossils.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "ge_category")
public class GeCategory implements Serializable {

	private static final long serialVersionUID = 1L;

	public GeCategory() {}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id", nullable = false)
	@ApiModelProperty(hidden = true)
	private Long id;

	@Column(name = "name", length = 64, nullable = false)
	private String name;

	@Column(name = "scale_unit", length = 64, nullable = false)
	private Long scaleUnit;

	@OneToMany(mappedBy = "geCat", cascade = CascadeType.ALL)
	@ApiModelProperty(hidden = true)
	private List<GeSubCategory> geSubCategories;

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

	public List<GeSubCategory> getGeSubCategories() {
		return geSubCategories;
	}

	public void setGeSubCategories(List<GeSubCategory> geSubCategories) {
		this.geSubCategories = geSubCategories;
	}

	public void setScaleUnit(Long scaleUnit) {
		this.scaleUnit = scaleUnit;
	}

}
