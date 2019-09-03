package com.fossils.fossils.dto;

import java.io.Serializable;

public class GeBlogDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String blogTitle;
	private String blogDescription;
	private String blogImageUrl;

	public GeBlogDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getBlogDescription() {
		return blogDescription;
	}

	public void setBlogDescription(String blogDescription) {
		this.blogDescription = blogDescription;
	}

	public String getBlogImageUrl() {
		return blogImageUrl;
	}

	public void setBlogImageUrl(String blogImageUrl) {
		this.blogImageUrl = blogImageUrl;
	}
	
	

}
