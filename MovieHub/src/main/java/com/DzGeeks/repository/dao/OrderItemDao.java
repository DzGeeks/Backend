package com.DzGeeks.repository.dao;

import com.DzGeeks.repository.entity.OrderItem;

public interface OrderItemDao {

	//增
	public void addOrderItem(OrderItem o);
	
	//根据id获取订单项
	public OrderItem getOrderItem(int id);
}
