package com.DzGeeks.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DzGeeks.business.OrderService;
import com.DzGeeks.repository.dao.impl.OrderDaoImpl;
import com.DzGeeks.repository.dao.impl.OrderItemDaoImpl;
import com.DzGeeks.repository.entity.Order;
import com.DzGeeks.repository.entity.OrderItem;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDaoImpl orderDao;
	
	@Autowired
	private OrderItemDaoImpl orderItemDao;
	
	//根据id获取订单
	public Order getOrder(int orderId) {
//		return orderDao.getOrder(orderId);
		Order order = new Order("15521155847", 32.0);
		return order;
	}

	//根据订单id获取订单项
	public List<OrderItem> getOrderItem(int orderId) {
		return orderItemDao.getOrderItems(orderId);
	}

	//新增订单
	public int createOrderItem(String phone, int playSessionId, int seatIndex) {
//		return orderItemDao.createOrderItem(phone, playSessionId, seatIndex);
		return 1;
	}

	//结束订单
	public int finishOrder(int orderId) {
		return orderDao.finishOrder(orderId);
	}

}
