package com.DzGeeks.controller.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DzGeeks.business.CinemaService;
import com.DzGeeks.repository.dao.impl.CinemaDaoImpl;
import com.DzGeeks.repository.dao.impl.PlaySessionDaoImpl;
import com.DzGeeks.repository.entity.Cinema;

@Service
public class CinemaServiceImpl implements CinemaService {

	@Autowired
	private CinemaDaoImpl cinemaDao;
	
	@Autowired
	private PlaySessionDaoImpl playSessionDao;
	
	//根据电影获取放映影院
	public List<Cinema> getCinemas(int filmId) {
//		return playSessionDao.getCinemas(filmId);

		return getTestCinemas();
	}

	private List<Cinema> getTestCinemas() {
		Cinema cinema_1 = new Cinema(1, "哈艺时尚影城(石榴岗路店)", 1, "15555555551");
		Cinema cinema_2 = new Cinema(2, "金逸珠江影城（大学城店）", 2, "15555555552");
		Cinema cinema_3 = new Cinema(3, "广州飞扬影城（正佳IMAX店）", 3, "15555555553");
		Cinema cinema_4 = new Cinema(4, "广州保利国际影城（中环店）", 4, "15555555554");
		Cinema cinema_5 = new Cinema(5, "广州五一影城（四季天地店）", 5, "15555555555");

		List<Cinema> cinemas = new LinkedList<Cinema>();
		cinemas.add(cinema_1);
		cinemas.add(cinema_2);
		cinemas.add(cinema_3);
		cinemas.add(cinema_4);
		cinemas.add(cinema_5);

		return cinemas;
	}


	//根据id获取影院
	public Cinema getCinema(int cinemaId) {
		return new Cinema(1, "哈艺时尚影城(石榴岗路店)", 1, "15555555551");
	}

}
