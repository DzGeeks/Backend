package com.DzGeeks.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DzGeeks.business.SeatService;
import com.DzGeeks.repository.dao.impl.SeatDaoImpl;
import com.DzGeeks.repository.entity.Seat;

@Service
public class SeatServiceImpl implements SeatService {
	
	@Autowired
	private SeatDaoImpl seatDao;

	//根据场次id获取座位信息
	public Seat getSeats(int playSessionId) {
		return seatDao.getSeats(playSessionId);
	}

	//购票修改座位信息
	public Boolean loakSeat(int seatId, int seatIndex) {
		return seatDao.loakSeat(seatId, seatIndex);
	}

}
