package com.DzGeeks.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DzGeeks.business.FilmTypeService;
import com.DzGeeks.repository.dao.impl.FilmDaoImpl;
import com.DzGeeks.repository.entity.FilmType;

@Service
public class FilmTypeServiceImpl implements FilmTypeService {

	@Autowired
	FilmDaoImpl filmDao;
	
	//根据电影获取类型列表
	public List<FilmType> getFilmTypes(int filmId) {
		return filmDao.getFilmTypes(filmId);
	}

}
