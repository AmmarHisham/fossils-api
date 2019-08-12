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
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "ge_subcategory")
//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
public class GeSubCategory implements Serializable {

	private static final long serialVersionUID = 1L;

	public GeSubCategory() {}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id", nullable = false)
	@ApiModelProperty(hidden = true)
	private Long id;

	@Column(name = "name", length = 64, nullable = false)
	private String name;

	@ManyToOne
	@JoinColumn(name = "ge_category_id")
	@ApiModelProperty(hidden = true)
	private GeCategory geCat;
	
	@OneToMany(mappedBy = "geSubCategory", cascade = CascadeType.ALL)
	@ApiModelProperty(hidden = true)
	private List<GeSubCategoryPost> geSubCategoriesPost;

	public List<GeSubCategoryPost> getGeSubCategoriesPost() {
		return geSubCategoriesPost;
	}

	public void setGeSubCategoriesPost(List<GeSubCategoryPost> geSubCategoriesPost) {
		this.geSubCategoriesPost = geSubCategoriesPost;
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

	public GeCategory getGeCat() {
		return geCat;
	}

	public void setGeCat(GeCategory geCat) {
		this.geCat = geCat;
	}

}
