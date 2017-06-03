package com.DzGeeks.repository.dao;

import com.DzGeeks.repository.entity.Cinema;

public interface CinemaDao {

	// 增
	public void addCinema(Cinema c);

	// 根据id获取电影院
	public Cinema getCinema(int id);
}
