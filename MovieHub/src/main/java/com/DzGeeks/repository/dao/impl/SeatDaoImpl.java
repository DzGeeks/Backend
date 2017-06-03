package com.DzGeeks.repository.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.DzGeeks.repository.dao.SeatDao;
import com.DzGeeks.repository.entity.Actor;
import com.DzGeeks.repository.entity.Seat;
import com.DzGeeks.util.DBSessionUtil;

@Repository
public class SeatDaoImpl implements SeatDao {

	// 增
	public void addSeat(Seat s) {
		Session session = DBSessionUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
		session.close();
	}

	// 根据id获取座位
	public Seat getSeat(int id) {
		Session session = DBSessionUtil.getSessionFactory().openSession();
		Seat s = (Seat) session.get(Seat.class, id);
		session.close();
		return s;
	}

	// 根据场次id获取座位信息
	public Seat getSeats(int playSessionId) {
		Session session = DBSessionUtil.getSessionFactory().openSession();
		Query query = session.createQuery(" from Seat s where s.playSessionId=:playSessionId");
		query.setParameter("playSessionId", playSessionId);
		Seat s = (Seat) query.uniqueResult();
		session.close();
		return s;
	}

	// 购票修改座位信息
	public Boolean loakSeat(int seatId, int seatIndex) {
		Session session = DBSessionUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Seat s = (Seat) session.get(Seat.class, seatId);
		String status = s.getStatus();
		String newStatus = status.substring(0, seatIndex) + "1" + status.substring(seatIndex + 1);
		s.setStatus(newStatus);
		session.update(s);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	public static void main(String[] args) {
		SeatDaoImpl seatDaoImpl = new SeatDaoImpl();
		Seat s = seatDaoImpl.getSeats(1);
		System.out.println(s.toString());
		seatDaoImpl.loakSeat(1, 2);
		s = seatDaoImpl.getSeats(1);
		System.out.println(s.toString());
	}

}
