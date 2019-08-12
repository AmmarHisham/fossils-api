package com.fossils.fossils.dto;

public class GESubCategoryPostDTO {


	private Long id;
	private GESubCategoryDTO geSubCategory;
	private String postDescription;
	private String postImage;
	private Long postYear;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public GESubCategoryDTO getGeSubCategory() {
		return geSubCategory;
	}

	public void setGeSubCategory(GESubCategoryDTO geSubCategory) {
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
