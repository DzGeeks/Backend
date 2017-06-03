package com.DzGeeks.repository.dao.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.DzGeeks.repository.dao.CinemaDao;
import com.DzGeeks.repository.entity.Cinema;
import com.DzGeeks.util.DBSessionUtil;

@Repository
public class CinemaDaoImpl implements CinemaDao {

	// 增
	public void addCinema(Cinema c) {
		Session session = DBSessionUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(c);
		session.getTransaction().commit();
		session.close();
	}

	// 根据id获取影院
	public Cinema getCinema(int id) {
		Session session = DBSessionUtil.getSessionFactory().openSession();
		Cinema c = (Cinema) session.get(Cinema.class, id);
		session.close();
		return c;
	}
}
