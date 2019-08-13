package com.fossils.fossils.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "ge_category")
public class GeCategory implements Serializable {

	private static final long serialVersionUID = 1L;

	public GeCategory() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", nullable = false)
	@ApiModelProperty(hidden = true)
	private Long id;

	@Column(name = "name", length = 64, nullable = false)
	private String name;

	@Column(name = "from_year", length = 64, nullable = false)
	private Long fromYear;

	@Column(name = "to_year", length = 64, nullable = false)
	private Long toYear;

	@Column(name = "scale_unit", length = 64, nullable = false)
	private String scaleUnit;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "geCat", cascade = CascadeType.ALL)
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

	public List<GeSubCategory> getGeSubCategories() {
		return geSubCategories;
	}

	public void setGeSubCategories(List<GeSubCategory> geSubCategories) {
		this.geSubCategories = geSubCategories;
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
