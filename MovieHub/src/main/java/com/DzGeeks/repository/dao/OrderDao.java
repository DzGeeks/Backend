package com.DzGeeks.repository.dao;

import java.util.List;

import com.DzGeeks.repository.entity.Order;
import com.DzGeeks.repository.entity.OrderItem;

public interface OrderDao {

	// 增
	public void addOrder(Order o);

	// 根据id获取订单
	public Order getOrder(int id);

	// 结束订单
	public int finishOrder(int orderId);

}
