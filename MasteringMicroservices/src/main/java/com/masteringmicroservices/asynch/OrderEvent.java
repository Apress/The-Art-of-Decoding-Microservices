package com.masteringmicroservices.asynch;

public class OrderEvent {

	private String orderId;
	private String orderStatus;
	
	public OrderEvent(String orderId, String orderStatus) {
		this.orderId = orderId;
		this.orderStatus = orderStatus;
	}
	
	public String getOrderId() {
		return orderId;
	}
	
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	public String getOrderStatus() {
		return orderStatus;
	}
	
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
}
