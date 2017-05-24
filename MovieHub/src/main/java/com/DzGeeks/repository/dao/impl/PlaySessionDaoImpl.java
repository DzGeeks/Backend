package com.DzGeeks.repository.dao.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.DzGeeks.repository.dao.PlaySessionDao;
import com.DzGeeks.repository.entity.PlaySession;
import com.DzGeeks.util.DBSessionUtil;

@Repository
public class PlaySessionDaoImpl implements PlaySessionDao {

	//增
	public void addPlaySession(PlaySession p) {
		Session session = DBSessionUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
		session.close();
	}
	
	//根据id获取场次
	public PlaySession getPlaySession(int id) {
		Session session = DBSessionUtil.getSessionFactory().openSession();
		PlaySession p = (PlaySession) session.get(PlaySession.class, id);
		session.close();
		return p;
	}
}
