package com.DzGeeks.repository.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.DzGeeks.repository.dao.FilmDao;
import com.DzGeeks.repository.entity.Actor;
import com.DzGeeks.repository.entity.Film;
import com.DzGeeks.repository.entity.FilmType;
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
	
	//根据电影获取类型列表
	public List<FilmType> getFilmTypes(int filmId) {
		Session session = DBSessionUtil.getSessionFactory().openSession();
		Film f = (Film) session.get(Film.class, filmId);
		Set<FilmType> set = f.getFilmTypes();
		List<FilmType> filmTypes = new ArrayList<FilmType>();
		for (FilmType type : set) {
			filmTypes.add(type);
		}
		session.close();
		return filmTypes;
	}
	
	//获取热门电影 --至多8个，按评分降序排序
	public List<Film> getHotMovies() {
		List<Film> films = new ArrayList<Film>();
		Session session = DBSessionUtil.getSessionFactory().openSession();
		Query query = session.createQuery(" from Film f order by f.score DESC");
		query.setMaxResults(8);
		films = query.list();
		session.close();
		return films;
	}
	
	//获取电影 --按评分降序排序
	public List<Film> getMovies(int startPage, int pageSize) {
		List<Film> films = new ArrayList<Film>();
		Session session = DBSessionUtil.getSessionFactory().openSession();
		Query query = session.createQuery(" from Film f");
		query.setFirstResult(startPage*pageSize+1);
		query.setMaxResults(8);
		films = query.list();
		//排序
		Collections.sort(films, new Comparator<Film>() {

			public int compare(Film f1, Film f2) {
				double score1 = f1.getScore();
				double score2 = f2.getScore();
				if (score1 > score2) return -1;
				else return 1;
			}
			
		});
		return films;
	}
	
	public static void main(String[] args) {
		FilmDaoImpl filmDaoImpl = new FilmDaoImpl();
//		List<FilmType> list = filmDaoImpl.getFilmTypes(1);
//		for (FilmType f : list) {
//			System.out.println(f.toString());
//		}
		
//		List<Film> films = filmDaoImpl.getHotMovies();
//		for (Film f : films) {
//			System.out.println(f.toString());
//		}
		
		List<Film> films = filmDaoImpl.getMovies(0, 5);
		for (Film f : films) {
			System.out.println(f.toString());
		}
	}
	
}
