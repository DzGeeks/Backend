package com.DzGeeks.repository.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.DzGeeks.repository.dao.OrderItemDao;
import com.DzGeeks.repository.entity.Order;
import com.DzGeeks.repository.entity.OrderItem;
import com.DzGeeks.repository.entity.PlaySession;
import com.DzGeeks.util.DBSessionUtil;

@Repository
public class OrderItemDaoImpl implements OrderItemDao {

	// 增
	public void addOrderItem(OrderItem o) {
		Session session = DBSessionUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(o);
		session.getTransaction().commit();
		session.close();
	}

	// 根据id获取订单项
	public OrderItem getOrderItem(int id) {
		Session session = DBSessionUtil.getSessionFactory().openSession();
		OrderItem o = (OrderItem) session.get(OrderItem.class, id);
		session.close();
		return o;
	}

	// 根据订单id获取订单项
	public List<OrderItem> getOrderItems(int orderId) {
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		Session session = DBSessionUtil.getSessionFactory().openSession();
		Query query = session.createQuery(
				"select new com.DzGeeks.repository.entity.OrderItem(o.itemId, o.playSessionId, o.seatIndex, o.orderId) "
						+ "from OrderItem o where o.orderId=:orderId");
		query.setParameter("orderId", orderId);
		orderItems = query.list();
		session.close();
		return orderItems;
	}

	// 新增订单
	public int createOrderItem(String phone, int playSessionId, int seatIndex) {
		Session session = DBSessionUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery(
				"select o.orderId, o.phone " + "from Order o, OrderItem oi where oi.playSessionId=:playSessionId and "
						+ "oi.orderId = o.orderId and o.phone=:phone");
		query.setParameter("playSessionId", playSessionId);
		query.setParameter("phone", phone);
		Object[] order = (Object[]) query.uniqueResult();
		if (order == null) { // 新建order
			PlaySession ps = (PlaySession) session.get(PlaySession.class, playSessionId);
			Order o = new Order(phone, ps.getPrice());
			session.save(o);
			// 获取orderId
			query = session.createQuery(
					"select o.orderId from Order o " + "where o.phone=:phone and o.totalPrice=:totalPrice");
			query.setParameter("phone", phone);
			query.setParameter("totalPrice", ps.getPrice());
			int id = (Integer) query.uniqueResult();
			o = (Order) session.get(Order.class, id);
			OrderItem oi = new OrderItem(playSessionId, seatIndex);
			oi.setOrderId(id);
			Set<OrderItem> s = new HashSet<OrderItem>();
			s.add(oi);
			o.setOrderItems(s);
			o.setTimeStamp(new Date().getTime());
			session.getTransaction().commit();
			session.close();
			return id;
		} else { // 往原有order新增orderItem
			int orderId = (Integer) order[0];
			Order o = (Order) session.get(Order.class, orderId);
			OrderItem oi = new OrderItem(playSessionId, seatIndex);
			oi.setOrderId(orderId);
			o.getOrderItems().add(oi);
			PlaySession ps = (PlaySession) session.get(PlaySession.class, playSessionId);
			o.setTotalPrice(o.getTotalPrice() + ps.getPrice());
			session.update(o);
			session.getTransaction().commit();
			session.close();
			return o.getOrderId();
		}
	}

	public static void main(String[] args) {
		OrderItemDaoImpl orderItemDaoImpl = new OrderItemDaoImpl();
		// List<OrderItem> orderItems = orderItemDaoImpl.getOrderItems(2);
		// for (OrderItem i : orderItems) {
		// System.out.println(i.toString());
		// }
		System.out.println(orderItemDaoImpl.createOrderItem("188", 1, 13));

	}
}
