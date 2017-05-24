package com.DzGeeks.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * 订单项
 */
@Entity
@Table(name = "OrderItem")
public class OrderItem {

	private int itemId; // 订单项id
	private int playSessionId; // 放映场次id
	private int seatIndex; // 作为索引
	private int orderId; // 所属订单id

	public OrderItem() {
	}

	public OrderItem(int playSessionId, int seatIndex) {
		this.playSessionId = playSessionId;
		this.seatIndex = seatIndex;
	}

	@Id
	@Column(name = "itemId", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	@Column(name = "playSessionId", nullable = false)
	public int getPlaySessionId() {
		return playSessionId;
	}

	public void setPlaySessionId(int playSessionId) {
		this.playSessionId = playSessionId;
	}

	@Column(name = "seatIndex", nullable = false)
	public int getSeatIndex() {
		return seatIndex;
	}

	public void setSeatIndex(int seatIndex) {
		this.seatIndex = seatIndex;
	}

	@Column(name = "orderId", nullable = false)
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "OrderItem [itemId=" + itemId + ", playSessionId=" + playSessionId + ", seatIndex=" + seatIndex
				+ ", orderId=" + orderId + "]";
	}

}
