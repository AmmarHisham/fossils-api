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

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "ge_subcategory_div_item")
public class GeSubCategoryDivisionItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", nullable = false)
	@ApiModelProperty(hidden = true)
	private Long id;

	@Column(name = "item_description")
	private String itemDescription;

	@Column(name = "item_image_url")
	private String itemImageUrl;

	@Column(name = "item_age")
	private Long itemAge;

	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ge_subcategory_div_id")
	@ApiModelProperty(hidden = true)
	private GeSubCategoryDivision geSubCategoryDivision;

	public GeSubCategoryDivisionItem() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public String getItemImageUrl() {
		return itemImageUrl;
	}

	public void setItemImageUrl(String itemImageUrl) {
		this.itemImageUrl = itemImageUrl;
	}

	public Long getItemAge() {
		return itemAge;
	}

	public void setItemAge(Long itemAge) {
		this.itemAge = itemAge;
	}

	public GeSubCategoryDivision getGeSubCategoryDivision() {
		return geSubCategoryDivision;
	}

	public void setGeSubCategoryDivision(GeSubCategoryDivision geSubCategoryDivision) {
		this.geSubCategoryDivision = geSubCategoryDivision;
	}
	
	@Override
	public String toString() {
		return "GeSubCategoryDivisionItem [id=" + id + ", itemDescription=" + itemDescription + ", itemImageUrl="
				+ itemImageUrl + ", itemAge=" + itemAge + "]";
	}
	

}
