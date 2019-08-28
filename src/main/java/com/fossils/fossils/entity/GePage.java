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

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "ge_page")
public class GePage implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", nullable = false)
	@ApiModelProperty(hidden = true)
	private Long id;

	@Column(name = "name", length = 64, nullable = false)
	private String name;

	@Column(name = "from_age", length = 64, nullable = false)
	private Long fromAge;

	@Column(name = "to_age", length = 64, nullable = false)
	private Long toAge;

	@Column(name = "scale_unit", length = 64, nullable = false)
	private Long scaleUnit;
	
	@JsonIgnore
	@OneToMany(mappedBy = "gePage", cascade = CascadeType.ALL, orphanRemoval=true)
	@ApiModelProperty(hidden = true)
	private List<GeCategory> geCategories;

	public List<GeCategory> getGeCategories() {
		return geCategories;
	}

	public void setGeCategories(List<GeCategory> geCategories) {
		this.geCategories = geCategories;
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

	public Long getScaleUnit() {
		return scaleUnit;
	}

	public void setScaleUnit(Long scaleUnit) {
		this.scaleUnit = scaleUnit;
	}

	@Override
	public String toString() {
		return "GePage [id=" + id + ", name=" + name + ", fromAge=" + fromAge + ", toAge=" + toAge + ", scaleUnit="
				+ scaleUnit + ", geCategories=" + geCategories + "]";
	}


}
