package com.DzGeeks.repository.dao.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.DzGeeks.repository.dao.ActorDao;
import com.DzGeeks.repository.entity.Actor;
import com.DzGeeks.repository.entity.Film;
import com.DzGeeks.util.DBSessionUtil;

@Repository
public class ActorDaoImpl implements ActorDao {

	//增
	public void addActor(Actor a) {
		Session session = DBSessionUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery(" from Actor a where a.name=:name");
		query.setParameter("name", a.getName());
		Actor actor = (Actor) query.uniqueResult();
		if (actor == null) session.save(a);
		session.getTransaction().commit();
		session.close();
	}
	
	//根据id获取Actor
	public Actor getActor(int id) {
		Session session = DBSessionUtil.getSessionFactory().openSession();
		Actor a = (Actor) session.get(Actor.class, id);
		session.close();
		return a;
	}

	public static void main(String[] args) {
		ActorDaoImpl actorDao = new ActorDaoImpl();
		Actor a = actorDao.getActor(1);
		if (a != null) System.out.println(a.toString());
	}

}



