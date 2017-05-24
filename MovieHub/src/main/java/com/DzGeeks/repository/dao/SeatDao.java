package com.DzGeeks.repository.dao;

import com.DzGeeks.repository.entity.Seat;

public interface SeatDao {

	//增
	public void addSeat(Seat s);
	
	//根据id获取座位信息
	public Seat getSeat(int id);
}
