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
@Table(name = "ge_category")
public class GeCategory implements Serializable {

	private static final long serialVersionUID = 1L;

	public GeCategory() {
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

	@Column(name = "bg_img_url", length = 64, nullable = false)
	private String bgImageURL;

	@JsonIgnore
	@OneToMany(mappedBy = "geCat", cascade = CascadeType.ALL, orphanRemoval=true)
	@ApiModelProperty(hidden = true)
	private List<GeSubCategory> child;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ge_page_id")
	@ApiModelProperty(hidden = true)
	private GePage gePage;

	public GePage getGePage() {
		return gePage;
	}

	public void setGePage(GePage gePage) {
		this.gePage = gePage;
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

	public List<GeSubCategory> getChild() {
		return child;
	}

	public void setChild(List<GeSubCategory> child) {
		this.child = child;
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

	public String getBgImageURL() {
		return bgImageURL;
	}

	public void setBgImageURL(String bgImageURL) {
		this.bgImageURL = bgImageURL;
	}

	@Override
	public String toString() {
		return "GeCategory [id=" + id + ", name=" + name + ", fromAge=" + fromAge + ", toAge=" + toAge + ", bgImageURL="
				+ bgImageURL + ", geSubCategories=" + child+"]";
	}



}
