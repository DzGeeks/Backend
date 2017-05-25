package com.DzGeeks.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DzGeeks.business.FilmService;
import com.DzGeeks.repository.dao.impl.FilmDaoImpl;
import com.DzGeeks.repository.entity.Film;

@Service
public class FilmServiceImpl implements FilmService {

	@Autowired
	private FilmDaoImpl filmDao;
	
	//获取热门电影 --至多8个，按评分降序排序
	public List<Film> getHotMovies() {
		return filmDao.getHotMovies();
	}

	//获取电影 --按评分降序排序
	public List<Film> getMovies(int startPage, int pageSize) {
		return filmDao.getMovies(startPage, pageSize);
	}

	//根据id获取电影
	public Film getOneMovie(int filmId) {
		return filmDao.getFilm(filmId);
	}

}
