package com.DzGeeks.repository.dao.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.DzGeeks.repository.dao.OrderItemDao;
import com.DzGeeks.repository.entity.OrderItem;
import com.DzGeeks.util.DBSessionUtil;

@Repository
public class OrderItemDaoImpl implements OrderItemDao {

	//增
	public void addOrderItem(OrderItem o) {
		Session session = DBSessionUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(o);
		session.getTransaction().commit();
		session.close();
	}
	
	//根据id获取订单项
	public OrderItem getOrderItem(int id) {
		Session session = DBSessionUtil.getSessionFactory().openSession();
		OrderItem o = (OrderItem) session.get(OrderItem.class, id);
		session.close();
		return o;
	}
}
