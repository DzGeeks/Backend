package com.DzGeeks.repository.dao;

import java.util.List;

import com.DzGeeks.repository.entity.OrderItem;

public interface OrderItemDao {

	// 增
	public void addOrderItem(OrderItem o);

	// 根据id获取订单项
	public OrderItem getOrderItem(int id);

	// 根据订单id获取订单项
	public List<OrderItem> getOrderItems(int orderId);

	// 新增订单
	public int createOrderItem(String phone, int playSessionId, int seatIndex);
}
