package com.DzGeeks.repository.dao;

import java.util.List;

import com.DzGeeks.repository.entity.Cinema;
import com.DzGeeks.repository.entity.PlaySession;

public interface PlaySessionDao {

	//增
	public void addPlaySession(PlaySession p);
	
	//根据id获取场次
	public PlaySession getPlaySession(int id);
	
	//根据电影获取放映影院
	public List<Cinema> getCinemas(int filmId);
	
	//根据电影和影院获取放映场次
	public List<PlaySession> getPlayingSessions(int filmId, int cinemaId);

}
