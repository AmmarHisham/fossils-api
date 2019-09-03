package com.fossils.fossils.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "ge_blog")
public class GeBlog implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", nullable = false)
	@ApiModelProperty(hidden = true)
	private Long id;

	@Column(name = "blog_title")
	private String blogTitle;

	@Column(name = "blog_description")
	private String blogDescription;

	@Column(name = "item_image_url")
	private String blogImageUrl;

	public GeBlog() {
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
