package com.DzGeeks.business;

import com.DzGeeks.repository.entity.Seat;

public interface SeatService {

	// 根据场次id获取座位信息
	public Seat getSeats(int playSessionId);

	// 购票修改座位信息
	public Boolean loakSeat(int seatId, int seatIndex);

}
