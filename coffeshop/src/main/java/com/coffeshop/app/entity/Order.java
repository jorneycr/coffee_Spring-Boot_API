package com.coffeshop.app.entity;
import java.io.Serializable;


import javax.persistence.*;



@Entity
@Table(name = "orders")
public class Order implements Serializable{

	private static final long serialVersionUID = 8108387325551406297L;

	//Campo id autoincremental
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String user;
	
	@Column
    private Long createdAt = System.currentTimeMillis();
	
    @Column
    private Long updatedAt;
    
    @Column
    private Long qty;
    
    public Long getQty() {
		return qty;
	}

	public void setQty(Long qty) {
		this.qty = qty;
	}

	public Long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	@Column
    private Long idProduct;
	
	private String status = "Pendiente";
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Long createdAt) {
		this.createdAt = createdAt;
	}

	public Long getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Long updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
