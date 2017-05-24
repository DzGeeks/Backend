package com.DzGeeks.repository.dao.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.DzGeeks.repository.dao.OrderDao;
import com.DzGeeks.repository.entity.Order;
import com.DzGeeks.util.DBSessionUtil;

@Repository
public class OrderDaoImpl implements OrderDao {

	//增
	public void addOrder(Order o) {
		Session session = DBSessionUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(o);
		session.getTransaction().commit();
		session.close();
	}
	
	//根据id获取订单
	public Order getOrder(int id) {
		Session session = DBSessionUtil.getSessionFactory().openSession();
		Order o = (Order) session.get(Order.class, id);
		session.close();
		return o;
	}
}
