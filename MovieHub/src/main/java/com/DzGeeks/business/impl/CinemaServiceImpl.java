package com.DzGeeks.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DzGeeks.business.CinemaService;
import com.DzGeeks.repository.dao.impl.CinemaDaoImpl;
import com.DzGeeks.repository.entity.Cinema;

@Service
public class CinemaServiceImpl implements CinemaService {

	@Autowired
	private CinemaDaoImpl cinemaDao;
	
	//根据电影获取放映影院
	public List<Cinema> getCinemas(int filmId) {
		
		
		return null;
	}

	//根据id获取影院
	public Cinema getCinema(int cinemaId) {
		return cinemaDao.getCinema(cinemaId);
	}

}
