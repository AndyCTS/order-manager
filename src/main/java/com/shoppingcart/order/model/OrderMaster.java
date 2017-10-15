package com.shoppingcart.order.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonFormat;

/*
 * Item entity class
 * These are generic items which can be part of catalog.
 */
@Entity
public class OrderMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;	
	
	private String orderName;
	
	private String orderDescription;
	
	private float totalAmount;
	
	private float finalAmount;
	
	private int offerPercentage;
	
	@JsonFormat(pattern="DD-MM-YYYY@HH:mm:ss")
	private Date createdDate;
	
	@JsonFormat(pattern="DD-MM-YYYY@HH:mm:ss")
	private Date modifiedDate;
	
	private String status;
	

	@OneToMany(cascade = CascadeType.ALL, mappedBy="orderId", orphanRemoval = true,fetch=FetchType.EAGER)
	private List<OrderItem> orderItems;




	public long getOrderId() {
		return orderId;
	}


	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}


	public String getOrderName() {
		return orderName;
	}


	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}


	public String getOrderDescription() {
		return orderDescription;
	}


	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}


	public float getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}


	public float getFinalAmount() {
		return finalAmount;
	}


	public void setFinalAmount(float finalAmount) {
		this.finalAmount = finalAmount;
	}


	public int getOfferPercentage() {
		return offerPercentage;
	}


	public void setOfferPercentage(int offerPercentage) {
		this.offerPercentage = offerPercentage;
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


	public List<OrderItem> getOrderItems() {
		return orderItems;
	}


	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	
	public OrderMaster() {
		
	}
	
	@Override
	public String toString() {
		return this.getOrderDescription();
	}
	
    
}
