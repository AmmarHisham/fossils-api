package com.fossils.fossils.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "GE_SUBCATEGORY_POST")
public class GeSubCategoryPost implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", nullable = false)
	@ApiModelProperty(hidden = true)
	private Long id;

	@Column(name = "post_description")
	private String postDescription;

	@Column(name = "post_image_url")
	private String postImageUrl;

	@Column(name = "post_year")
	private Long postYear;

	@ApiModelProperty(hidden = true)
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ge_subcategory_id")
	private GeSubCategory geSubCategory;

	public GeSubCategoryPost() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPostDescription() {
		return postDescription;
	}

	public void setPostDescription(String postDescription) {
		this.postDescription = postDescription;
	}

	public String getPostImageUrl() {
		return postImageUrl;
	}

	public void setPostImageUrl(String postImageUrl) {
		this.postImageUrl = postImageUrl;
	}

	public Long getPostYear() {
		return postYear;
	}

	public void setPostYear(Long postYear) {
		this.postYear = postYear;
	}

	public GeSubCategory getGeSubCategory() {
		return geSubCategory;
	}

	public void setGeSubCategory(GeSubCategory geSubCategory) {
		this.geSubCategory = geSubCategory;
	}

}
