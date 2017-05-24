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

	//增
	public void addSeat(Seat s) {
		Session session = DBSessionUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
		session.close();
	}
	
	//根据id获取座位
	public Seat getSeat(int id) {
		Session session = DBSessionUtil.getSessionFactory().openSession();
		Seat s = (Seat) session.get(Seat.class, id);
		session.close();
		return s;
	}

}
