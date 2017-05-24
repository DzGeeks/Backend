package com.DzGeeks.repository.dao;

import com.DzGeeks.repository.entity.PlaySession;

public interface PlaySessionDao {

	//增
	public void addPlaySession(PlaySession p);
	
	//根据id获取场次
	public PlaySession getPlaySession(int id);
}
