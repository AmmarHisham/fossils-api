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

	@Column(name = "from_year", length = 64, nullable = false)
	private Long from;

	@Column(name = "to_year", length = 64, nullable = false)
	private Long to;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ge_category_id")
	@ApiModelProperty(hidden = true)
	private GeCategory geCat;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "geSubCategory", cascade = CascadeType.ALL)
	@ApiModelProperty(hidden = true)
	private List<GeSubCategoryPost> geSubCategoriesPost;
	
	public Long getFrom() {
		return from;
	}

	public void setFrom(Long from) {
		this.from = from;
	}

	public Long getTo() {
		return to;
	}

	public void setTo(Long to) {
		this.to = to;
	}


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
