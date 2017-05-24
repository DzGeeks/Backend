package com.DzGeeks.repository.dao;

import com.DzGeeks.repository.entity.Order;

public interface OrderDao {

	//增
	public void addOrder(Order o);
	
	//根据id获取订单
	public Order getOrder(int id);
}
