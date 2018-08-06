package com.pabs.test.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_detail")
public class OrderDetails implements Serializable{
		private static final long serialVersionUID = 1L;

	@Id
	@Column(name="order_id")
	private Long orderId;
	
	@Id
	@Column(name="item_id")
	private Long itemId;
	
	@Column(name="quantity")
	private int itemQty;
	
	@Column(name="purchase_price")
	private int itemPrice;
	
	@ManyToOne
	@JoinColumn(name = "order_id", nullable = false)
	private Order orderMain;

	public Order getOrderMain() {
		return orderMain;
	}

	public void setOrderMain(Order orderMain) {
		this.orderMain = orderMain;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public int getItemQty() {
		return itemQty;
	}

	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
}
