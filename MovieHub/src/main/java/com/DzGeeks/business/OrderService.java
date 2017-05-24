package com.DzGeeks.business;

import java.util.List;

import com.DzGeeks.repository.entity.Order;
import com.DzGeeks.repository.entity.OrderItem;

public interface OrderService {

	//新增订单
//	public int createOrderItem()
	
	//根据id获取订单
	public Order getOrder(int orderId);
	
	//根据订单id获取订单项
	public List<OrderItem> getOrderItem(int orderId);
	
}



