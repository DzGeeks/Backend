package com.DzGeeks.repository.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * 订单类
 */
@Entity
@Table(name = "myOrder")
public class Order {

	private int orderId; // 订单id
	private String phone; // 用户手机号码
	private double totalPrice; // 总价格
	private long timeStamp; // 订单时间戳
	private int finished; // 完成订单
	private Set<OrderItem> orderItems; // 订单项

	public Order() {
	}

	public Order(String phone, double totalPrice) {
		this.phone = phone;
		this.totalPrice = totalPrice;
		this.timeStamp = 0;
		this.finished = 0;
	}

	@Id
	@Column(name = "orderId", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	@Column(name = "phone", nullable = false, length = 45)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "totalPrice", nullable = false)
	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@OneToMany(targetEntity = OrderItem.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "orderId", referencedColumnName = "orderId")
	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@Column(name = "timeStamp", nullable = false)
	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Column(name = "finished", nullable = false)
	public int getFinished() {
		return finished;
	}

	public void setFinished(int finished) {
		this.finished = finished;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", phone=" + phone + ", totalPrice=" + totalPrice + "]";
	}

}
