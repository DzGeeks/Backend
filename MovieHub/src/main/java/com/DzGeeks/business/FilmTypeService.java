package com.DzGeeks.business;

import java.util.List;

import com.DzGeeks.repository.entity.FilmType;

public interface FilmTypeService {

	// 根据电影获取类型列表
	public List<FilmType> getFilmTypes(int filmId);

}
