package com.DzGeeks.repository.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.DzGeeks.repository.dao.OrderDao;
import com.DzGeeks.repository.entity.Order;
import com.DzGeeks.repository.entity.OrderItem;
import com.DzGeeks.util.DBSessionUtil;

@Repository
public class OrderDaoImpl implements OrderDao {

	// 增
	public void addOrder(Order o) {
		Session session = DBSessionUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(o);
		session.getTransaction().commit();
		session.close();
	}

	// 根据id获取订单
	public Order getOrder(int id) {
		Session session = DBSessionUtil.getSessionFactory().openSession();
		Order o = (Order) session.get(Order.class, id);
		session.close();
		return o;
	}

	// 结束订单
	public int finishOrder(int orderId) {
		Session session = DBSessionUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Order o = (Order) session.get(Order.class, orderId);
		if ((new Date().getTime() - o.getTimeStamp()) / (1000 * 60) >= 15)
			return 404; // 超时
		else {
			o.setFinished(1);
			session.update(o);
		}
		session.getTransaction().commit();
		session.close();
		return 200;
	}

	public static void main(String[] args) {
		OrderDaoImpl orderDaoImpl = new OrderDaoImpl();
		orderDaoImpl.finishOrder(9);
	}

}
