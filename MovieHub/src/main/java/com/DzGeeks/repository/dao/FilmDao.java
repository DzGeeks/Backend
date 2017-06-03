package com.DzGeeks.repository.dao;

import java.util.List;

import com.DzGeeks.repository.entity.Actor;
import com.DzGeeks.repository.entity.Film;
import com.DzGeeks.repository.entity.FilmType;

public interface FilmDao {

	// 增
	public void addFilm(Film f);

	// 根据id获取电影
	public Film getFilm(int id);

	// 根据电影获取演员列表
	public List<Actor> getActors(int filmId);

	// 根据电影获取类型列表
	public List<FilmType> getFilmTypes(int filmId);

	// 获取热门电影 --至多8个，按评分降序排序
	public List<Film> getHotMovies();

	// 获取电影 --按评分降序排序
	public List<Film> getMovies(int startPage, int pageSize);
}
