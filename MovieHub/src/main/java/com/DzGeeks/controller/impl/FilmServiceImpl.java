package com.DzGeeks.controller.impl;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.DzGeeks.repository.entity.Actor;
import com.DzGeeks.repository.entity.FilmType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DzGeeks.business.FilmService;
import com.DzGeeks.repository.dao.impl.FilmDaoImpl;
import com.DzGeeks.repository.entity.Film;

@Service
public class FilmServiceImpl implements FilmService {

//	@Autowired
//	private FilmDaoImpl filmDao;

	private List<Film> getTestFilmList() {
		List<Film> films = new LinkedList<Film>();

		// filmId = 1
		Film film_1 = new Film("摔跤吧爸爸", 9.5, 120, 2017,
				"youngdou", "这是一个温暖幽默的励志故事。马哈维亚辛格珀尕（阿米尔汗饰）曾是印度国家摔跤冠军，因生活所迫放弃摔跤。他希望让儿子可以帮他完成梦想——赢得世界级金牌。结果生了四个女儿本以为梦想就此破碎的辛格却意外发现女儿身上的惊人天..");

		film_1.setFilmId(1);

		Set<Actor> actors = new HashSet<Actor>();
		Actor actor = new Actor("周星驰");
		Actor actor1 = new Actor("吴孟达");
		actors.add(actor);
		actors.add(actor1);

		Set<FilmType> types = new HashSet<FilmType>();
		FilmType filmType_1 = new FilmType("喜剧");
		FilmType filmType_2 = new FilmType("悬疑");
		types.add(filmType_1);
		types.add(filmType_2);

		film_1.setActors(actors);
		film_1.setFilmTypes(types);

		// filmId = 2
		Film film_2 = new Film("哆啦A梦：大雄的南极冰冰凉大冒险", 6.7, 132, 2016,
				"youngdou_2", "夏天来了，经不住大雄的百般纠缠，哆啦A梦第一次同意带着小伙伴们来到南极，并建造了专属的南极乐园。没想到这场消夏之旅，被偶然发现的金环打断，快乐的旅程就此中止，他们来到十万年前的南极。这一次，哆啦A梦面临生死考验，地球也面..");
		film_2.setFilmId(2);

		film_2.setActors(actors);
		film_2.setFilmTypes(types);

		/*
		film 集合
		 */
		films.add(film_1);
		films.add(film_2);
		return  films;
	}
	//获取热门电影 --至多8个，按评分降序排序
	public List<Film> getHotMovies() {
//		return filmDao.getHotMovies();


		return getTestFilmList();
	}

	//获取电影 --按评分降序排序
	public List<Film> getMovies(int startPage, int pageSize) {
//		return filmDao.getMovies(startPage, pageSize);

		return getTestFilmList();
	}

	//根据id获取电影
	public Film getOneMovie(int filmId) {
//		return filmDao.getFilm(filmId);

		for (Film film : getTestFilmList()) {
			if (film.getFilmId() == filmId)  return film;
		}

		return getTestFilmList().get(0);
	}

}
