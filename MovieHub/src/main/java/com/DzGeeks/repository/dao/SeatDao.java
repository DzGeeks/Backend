package com.DzGeeks.repository.dao;

import com.DzGeeks.repository.entity.Seat;

public interface SeatDao {

	// 增
	public void addSeat(Seat s);

	// 根据id获取座位信息
	public Seat getSeat(int id);

	// 根据场次id获取座位信息
	public Seat getSeats(int playSessionId);

	// 购票修改座位信息
	public Boolean loakSeat(int seatId, int seatIndex);

}
