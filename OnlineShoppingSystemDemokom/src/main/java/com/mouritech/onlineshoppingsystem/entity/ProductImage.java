package com.mouritech.onlineshoppingsystem.entity;

import java.util.Arrays;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="product_image")
public class ProductImage {
	
	@Id
	@Column(name="image_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long imageId;

	@Column(name="image_name")
	private String imageName;
	
	@Column(name = "image_type")
	private String imageType;
	
	@Column(name = "picByte", length = Integer.MAX_VALUE)
	private byte[] picByte;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "prodId")
	//@OnDelete(action = OnDeleteAction.CASCADE)
	private Product product;

	public ProductImage() {
		super();
	}

	public Long getImageId() {
		return imageId;
	}

	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public byte[] getPicByte() {
		return picByte;
	}

	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}



	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProductImage(String imageName, String imageType, byte[] picByte) {
	
		this.imageName = imageName;
		this.imageType = imageType;
		this.picByte = picByte;
	}

	@Override
	public String toString() {
		return "ProductImage [imageId=" + imageId + ", imageName=" + imageName + ", imageType=" + imageType
				+ ", picByte=" + Arrays.toString(picByte) +"]";
	}


	
}