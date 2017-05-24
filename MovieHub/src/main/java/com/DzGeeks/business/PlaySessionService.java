package com.DzGeeks.business;

import java.util.List;

import com.DzGeeks.repository.entity.PlaySession;

public interface PlaySessionService {

	//根据电影和影院获取放映场次
	public List<PlaySession> getPlayingSessions(int filmId, int cinemaId);
	
	//根据id获取场次信息
	public PlaySession selectPlaySession(int playSessionId);
	
	
}
