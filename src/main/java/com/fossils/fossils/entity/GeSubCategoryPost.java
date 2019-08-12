package com.fossils.fossils.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "GE_SUBCATEGORY_POST")
public class GeSubCategoryPost implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id", nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "ge_subcategory_id")
	private GeSubCategory geSubCategory;

	@Column(name = "post_description", length = 64, nullable = false)
	private String postDescription;

	@Column(name = "post_image", length = 64, nullable = false)
	private String postImage;

	@Column(name = "post_year", length = 64, nullable = false)
	private Long postYear;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public GeSubCategory getGeSubCategory() {
		return geSubCategory;
	}

	public void setGeSubCategory(GeSubCategory geSubCategory) {
		this.geSubCategory = geSubCategory;
	}

	public String getPostDescription() {
		return postDescription;
	}

	public void setPostDescription(String postDescription) {
		this.postDescription = postDescription;
	}

	public String getPostImage() {
		return postImage;
	}

	public void setPostImage(String postImage) {
		this.postImage = postImage;
	}

	public Long getPostYear() {
		return postYear;
	}

	public void setPostYear(Long postYear) {
		this.postYear = postYear;
	}

}
