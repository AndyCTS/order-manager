package com.shoppingcart.order.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

/*
 * Item entity class
 * These are generic items which can be part of order.
 */
@Entity
public class OrderItem {
	
	@Id
	@GeneratedValue(
			strategy = GenerationType.AUTO,
			generator="native"
	)
	@GenericGenerator(
			name="native",
			strategy="native"
	)	
	private long itemId;
	
	private String name;
	
	private String description;
	
	private float price;
	
	private String type;
	
	//@Column(name = "REQUEST_DATE", nullable = false, columnDefinition = "date default sysdate")
	@JsonFormat(pattern="DD-MM-YYYY@HH:mm:ss")
	private Date createdDate;
	
	@JsonFormat(pattern="DD-MM-YYYY@HH:mm:ss")
	private Date modifiedDate;
	
	private String status;	
	
	private Long orderId;

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
	public OrderItem() {
		
	}
	
	


}

