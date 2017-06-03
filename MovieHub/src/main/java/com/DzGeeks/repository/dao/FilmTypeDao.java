package com.DzGeeks.repository.dao;

import com.DzGeeks.repository.entity.FilmType;

public interface FilmTypeDao {

	// 增
	public void addFilmType(FilmType f);

	// 根据id获取类型
	public FilmType getFilmType(int id);
}
