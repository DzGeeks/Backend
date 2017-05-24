package com.DzGeeks.repository.dao;

import java.util.List;

import com.DzGeeks.repository.entity.Actor;
import com.DzGeeks.repository.entity.Film;

public interface FilmDao {

	//增
	public void addFilm(Film f);
	
	//根据id获取电影
	public Film getFilm(int id);
	
	//根据电影获取演员列表
	public List<Actor> getActors(int filmId);
}
