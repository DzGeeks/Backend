package com.DzGeeks.repository.dao.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.DzGeeks.repository.dao.FilmDao;
import com.DzGeeks.repository.entity.Actor;
import com.DzGeeks.repository.entity.Film;
import com.DzGeeks.util.DBSessionUtil;

@Repository
public class FilmDaoImpl implements FilmDao {

	//增
	public void addFilm(Film f) {
		Session session = DBSessionUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery(" from Film f where f.name=:name");
		query.setParameter("name", f.getName());
		
		Film film = (Film) query.uniqueResult();
		if (film == null) session.save(f);
		session.getTransaction().commit();
		session.close();
	}
	
	//根据id获取电影
	public Film getFilm(int id) {
		Session session = DBSessionUtil.getSessionFactory().openSession();
		Film f = (Film) session.get(Film.class, id);
		session.close();
		return f;
	}
	
	//根据电影获取演员列表
	public List<Actor> getActors(int filmId) {
		Session session = DBSessionUtil.getSessionFactory().openSession();
		Film f = (Film) session.get(Film.class, filmId);
		Set<Actor> set = f.getActors();
		List<Actor> actors = new ArrayList<Actor>();
		for (Actor a : set) {
			actors.add(a);
		}
		session.close();
		return actors;
	}
	
}
