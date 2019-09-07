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

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "ge_subcategory_div")
public class GeSubCategoryDivision implements Serializable {

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

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ge_subcategory_id")
	@ApiModelProperty(hidden = true)
	private GeSubCategory geSubCategory;

	@OneToMany(mappedBy = "geSubCategoryDivision", cascade = CascadeType.ALL, orphanRemoval=true)
	@ApiModelProperty(hidden = true)
	private List<GeSubCategoryDivisionItem> child;

	public GeSubCategoryDivision() {
		super();
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

	public GeSubCategory getGeSubCategory() {
		return geSubCategory;
	}

	public void setGeSubCategory(GeSubCategory geSubCategory) {
		this.geSubCategory = geSubCategory;
	}

	public List<GeSubCategoryDivisionItem> getChild() {
		return child;
	}

	public void setChild(List<GeSubCategoryDivisionItem> child) {
		this.child = child;
	}

	@Override
	public String toString() {
		return "GeSubCategoryDivision [id=" + id + ", name=" + name + ", fromAge=" + fromAge + ", toAge=" + toAge
			+ ", geSubCategoriesDivisionItem=" + child
				+ "]";
	}


}
