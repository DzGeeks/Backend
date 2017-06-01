package com.DzGeeks.controller.impl;

import java.beans.Expression;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javafx.scene.input.DataFormat;
import org.springframework.beans.ExtendedBeanInfoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DzGeeks.business.PlaySessionService;
import com.DzGeeks.repository.dao.impl.PlaySessionDaoImpl;
import com.DzGeeks.repository.entity.PlaySession;

@Service
public class PlaySessionServiceImpl implements PlaySessionService {
	
	@Autowired
	private PlaySessionDaoImpl playSessionDao;

	//根据电影和影院获取放映场次
	public List<PlaySession> getPlayingSessions(int filmId, int cinemaId) throws ParseException {
//		return playSessionDao.getPlayingSessions(filmId, cinemaId);

		return getTestPlaySession();

	}

	//根据id获取场次信息
	public PlaySession selectPlaySession(int playSessionId)  {

		List<PlaySession> playSessionList = null;
		try {
			playSessionList = getTestPlaySession();
		} catch (Exception e) {
			return null;
		}

		for (PlaySession pl : playSessionList) {
			if (playSessionId == pl.getPlaySessionId()) return pl;
		}
		return playSessionList.get(0);


	}

	private List<PlaySession> getTestPlaySession() throws ParseException {
		SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		// 1
		String dataStr_1 = "2017-06-12 15:12:12";
		PlaySession playSession_1 = new PlaySession(1, dataFormat.parse(dataStr_1), "12:00", "15:00", "英语", 30,
				"5号厅", 1, 3, 9.5);
		playSession_1.setPlaySessionId(1);

		// 2
		String dataStr_2 = "2017-06-12 15:12:12";
		PlaySession playSession_2 = new PlaySession(2, dataFormat.parse(dataStr_1), "12:00", "15:00", "英语", 30,
				"5号厅", 1, 3, 9.5);
		playSession_1.setPlaySessionId(2);

		// 3
		String dataStr_3 = "2017-06-12 15:12:12";
		PlaySession playSession_3 = new PlaySession(3, dataFormat.parse(dataStr_1), "12:00", "15:00", "英语", 30,
				"5号厅", 1, 2, 9.5);
		playSession_1.setPlaySessionId(3);


		//-----------下一个时间段

		// 4
		String dataStr_4 = "2017-06-13 15:12:12";
		PlaySession playSession_4 = new PlaySession(4, dataFormat.parse(dataStr_1), "12:00", "15:00", "英语", 30,
				"5号厅", 1, 3, 9.5);
		playSession_1.setPlaySessionId(4);

		// 5
		String dataStr_5 = "2017-06-13 15:12:12";
		PlaySession playSession_5 = new PlaySession(5, dataFormat.parse(dataStr_1), "12:00", "15:00", "英语", 30,
				"5号厅", 1, 3, 9.5);
		playSession_1.setPlaySessionId(5);

		// 6
		String dataStr_6 = "2017-06-13 15:12:12";
		PlaySession playSession_6 = new PlaySession(6, dataFormat.parse(dataStr_1), "12:00", "15:00", "英语", 30,
				"5号厅", 1, 3, 9.5);
		playSession_1.setPlaySessionId(6);

		// ----------组合起来
		List<PlaySession> playSessionList = new LinkedList<PlaySession>();
		playSessionList.add(playSession_1);
		playSessionList.add(playSession_2);
		playSessionList.add(playSession_3);
		playSessionList.add(playSession_4);
		playSessionList.add(playSession_5);
		playSessionList.add(playSession_6);

		return playSessionList;
	}
}
