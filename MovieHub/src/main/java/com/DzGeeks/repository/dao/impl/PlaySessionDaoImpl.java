package com.DzGeeks.repository.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.DzGeeks.repository.dao.PlaySessionDao;
import com.DzGeeks.repository.entity.Cinema;
import com.DzGeeks.repository.entity.PlaySession;
import com.DzGeeks.util.DBSessionUtil;

@Repository
public class PlaySessionDaoImpl implements PlaySessionDao {

	// 增
	public void addPlaySession(PlaySession p) {
		Session session = DBSessionUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
		session.close();
	}

	// 根据id获取场次
	public PlaySession getPlaySession(int id) {
		Session session = DBSessionUtil.getSessionFactory().openSession();
		PlaySession p = (PlaySession) session.get(PlaySession.class, id);
		session.close();
		return p;
	}

	// 根据电影获取放映影院
	public List<Cinema> getCinemas(int filmId) {
		List<Cinema> cinemas = new ArrayList<Cinema>();
		Session session = DBSessionUtil.getSessionFactory().openSession();
		Query query = session.createQuery(
				"select new com.DzGeeks.repository.entity.Cinema(c.cinemaId, c.name, c.addressId, c.phone) "
						+ "from PlaySession p, Cinema c where p.filmId=:filmId and p.cinemaId=c.cinemaId");
		query.setParameter("filmId", filmId);
		cinemas = query.list();
		session.close();
		return cinemas;
	}

	// 根据电影和影院获取放映场次
	public List<PlaySession> getPlayingSessions(int filmId, int cinemaId) {
		List<PlaySession> playSessions = new ArrayList<PlaySession>();
		Session session = DBSessionUtil.getSessionFactory().openSession();
		Query query = session.createQuery(" from PlaySession p where p.filmId=:filmId and p.cinemaId=:cinemaId");
		query.setParameter("filmId", filmId);
		query.setParameter("cinemaId", cinemaId);
		playSessions = query.list();
		session.close();
		return playSessions;
	}

	public static void main(String[] args) {
		PlaySessionDaoImpl playSessionDaoImpl = new PlaySessionDaoImpl();
		// List<Cinema> cinemas = playSessionDaoImpl.getCinemas(1);
		// for (Cinema c : cinemas) {
		// System.out.println(c.toString());
		// }
		List<PlaySession> playSessions = playSessionDaoImpl.getPlayingSessions(1, 1);
		for (PlaySession p : playSessions) {
			System.out.println(p.toString());
		}

	}

}
