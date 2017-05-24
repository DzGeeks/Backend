package com.DzGeeks.business;

import java.util.List;

import com.DzGeeks.repository.entity.Cinema;

public interface CinemaService {

	//根据电影获取放映影院
	public List<Cinema> getCinemas(int filmId);

	//根据id获取影院
	public Cinema getCinema(int cinemaId);
}

