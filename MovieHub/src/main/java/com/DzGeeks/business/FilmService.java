package com.DzGeeks.business;

import java.util.List;

import com.DzGeeks.repository.entity.Film;

public interface FilmService {

	// 获取热门电影 --至多8个，按评分降序排序
	public List<Film> getHotMovies();

	// 获取电影 --按评分降序排序
	public List<Film> getMovies(int startPage, int pageSize);

	// 根据id获取电影
	public Film getOneMovie(int filmId);

}
