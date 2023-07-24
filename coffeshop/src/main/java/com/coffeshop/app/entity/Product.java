package com.coffeshop.app.entity;

import java.io.Serializable;


import javax.persistence.*;


@Entity
@Table(name = "products")
public class Product implements Serializable {


	private static final long serialVersionUID = 1476621882025890338L;

	//Campo id autoincremental
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50)
	private String name;
	
	private String image;
	
	private Float price;
	
	@Column
    private Long created = System.currentTimeMillis();
	
	
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	
    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
    	this.created = created;
    }
    
	 
}