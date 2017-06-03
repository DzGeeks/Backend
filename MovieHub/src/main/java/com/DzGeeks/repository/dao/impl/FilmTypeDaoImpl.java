package com.DzGeeks.repository.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.DzGeeks.repository.dao.FilmTypeDao;
import com.DzGeeks.repository.entity.Film;
import com.DzGeeks.repository.entity.FilmType;
import com.DzGeeks.util.DBSessionUtil;

@Repository
public class FilmTypeDaoImpl implements FilmTypeDao {

	// 增
	public void addFilmType(FilmType f) {
		Session session = DBSessionUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery(" from FilmType f where f.name=:name");
		query.setParameter("name", f.getName());
		FilmType filmType = (FilmType) query.uniqueResult();
		if (filmType == null)
			session.save(f);
		session.getTransaction().commit();
		session.close();
	}

	// 根据id获取类型
	public FilmType getFilmType(int id) {
		Session session = DBSessionUtil.getSessionFactory().openSession();
		FilmType f = (FilmType) session.get(FilmType.class, id);
		session.close();
		return f;
	}
}
