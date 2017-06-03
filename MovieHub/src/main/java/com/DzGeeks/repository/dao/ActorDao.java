package com.DzGeeks.repository.dao;

import java.util.List;

import com.DzGeeks.repository.entity.Actor;

public interface ActorDao {

	// 增
	public void addActor(Actor a);

	// 根据id获取Actor
	public Actor getActor(int id);

}
