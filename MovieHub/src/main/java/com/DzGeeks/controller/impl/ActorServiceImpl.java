package com.DzGeeks.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DzGeeks.business.ActorService;
import com.DzGeeks.repository.dao.impl.FilmDaoImpl;
import com.DzGeeks.repository.entity.Actor;

@Service
public class ActorServiceImpl implements ActorService {
	
	@Autowired
	FilmDaoImpl filmDao;
	
	//根据电影获取演员列表
	public List<Actor> getActorsInMovie(int filmId) {
		return filmDao.getActors(filmId);
	}

}
