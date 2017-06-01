package com.DzGeeks.controller;

import com.DzGeeks.business.FilmService;
import com.DzGeeks.repository.entity.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2017/5/25.
 */

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    FilmService filmService;

    @GetMapping("index")
    public String getIndexPage(@RequestParam(value = "start", required = false, defaultValue = "0") int start,
                               @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                               Model model) {

        // 正在的放映的电影
        List<Film> playingFilms = filmService.getMovies(start, pageSize);

        // 正在热映的电影 5 个
        List<Film> hotFilms = filmService.getHotMovies();

        // TODO: 2017/6/1 首页动态获取海报
        model.addAttribute("playingFilms", playingFilms);
        model.addAttribute("hotFilms", hotFilms);

        return "index";
    }
}
