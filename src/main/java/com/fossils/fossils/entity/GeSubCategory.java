package com.fossils.fossils.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "ge_subcategory")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class GeSubCategory implements Serializable {

	private static final long serialVersionUID = 1L;

	public GeSubCategory() {
	}

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

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ge_category_id")
	@ApiModelProperty(hidden = true)
	private GeCategory geCat;

	@OneToMany(mappedBy = "geSubCategory", cascade = CascadeType.ALL, orphanRemoval = true)
	@ApiModelProperty(hidden = true)
	private List<GeSubCategoryDivision> child;

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

	public GeCategory getGeCat() {
		return geCat;
	}

	public void setGeCat(GeCategory geCat) {
		this.geCat = geCat;
	}

	public List<GeSubCategoryDivision> getChild() {
		return child;
	}

	public void setChild(List<GeSubCategoryDivision> child) {
		this.child = child;
	}

	@Override
	public String toString() {
		return "GeSubCategory [id=" + id + ", name=" + name + ", fromAge=" + fromAge + ", toAge=" + toAge
				+ ", geSubCategoriesDivision=" + child + "]";
	}

}
