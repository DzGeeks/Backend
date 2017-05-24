package com.DzGeeks.business;

import java.util.List;

import com.DzGeeks.repository.entity.Actor;

public interface ActorService {

	//根据电影获取演员列表
	public List<Actor> getActorsInMovie(int filmId);
	
}
