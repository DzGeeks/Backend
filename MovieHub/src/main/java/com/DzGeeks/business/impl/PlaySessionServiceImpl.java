package com.DzGeeks.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DzGeeks.business.PlaySessionService;
import com.DzGeeks.repository.dao.impl.PlaySessionDaoImpl;
import com.DzGeeks.repository.entity.PlaySession;

@Service
public class PlaySessionServiceImpl implements PlaySessionService {

	@Autowired
	private PlaySessionDaoImpl playSessionDao;

	// 根据电影和影院获取放映场次
	public List<PlaySession> getPlayingSessions(int filmId, int cinemaId) {
		return playSessionDao.getPlayingSessions(filmId, cinemaId);
	}

	// 根据id获取场次信息
	public PlaySession selectPlaySession(int playSessionId) {
		return playSessionDao.getPlaySession(playSessionId);
	}

}
