//package com.DzGeeks.test;
//
//import java.util.Date;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import org.hibernate.Session;
//import org.junit.Test;
//
//import com.DzGeeks.repository.dao.impl.ActorDaoImpl;
//import com.DzGeeks.repository.dao.impl.FilmDaoImpl;
//import com.DzGeeks.repository.entity.Actor;
//import com.DzGeeks.repository.entity.Film;
//import com.DzGeeks.util.DBSessionUtil;
//
//public class TestDao {
//
//	@Test
//	public void test() {
//		System.out.println(new Date().getTime());
//		System.out.println("haha" + "adas");
//		System.out.println(new Date().getTime());
//	}
//
//	@Test
//	public void testActor() {
//		ActorDaoImpl actorDaoImpl = new ActorDaoImpl();
//		Actor a = new Actor("Lin");
//		actorDaoImpl.addActor(a);
//	}
//
//	@Test
//	public void testFilmDao() {
//		FilmDaoImpl filmDaoImpl = new FilmDaoImpl();
//
//		Set<Film> films = new HashSet<Film>();
//		Film f1 = new Film("bucuo", 5.6, 45, 2012, "linlin", "haokan");
//		films.add(f1);
//
//		Set<Actor> s = new HashSet<Actor>();
//		Actor a1 = new Actor("qwe");
//		Actor a2 = new Actor("asd");
//		Actor a3 = new Actor("zxc");
//		s.add(a1);
//		s.add(a2);
//		s.add(a3);
//
//		f1.setActors(s);
//
//		filmDaoImpl.addFilm(f1);
//
//	}
//
//	@Test
//	public void testFilmDaoGetActors() {
//		FilmDaoImpl filmDaoImpl = new FilmDaoImpl();
//		List<Actor> actors = filmDaoImpl.getActors(10);
//		for (Actor a : actors) {
//			System.out.println(a.toString());
//		}
//	}
//
//}
