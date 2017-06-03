package com.DzGeeks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.DzGeeks.business.FilmService;
import com.DzGeeks.repository.entity.Film;

@Controller
@RequestMapping("/")
public class IndexController {

	@Autowired
	FilmService filmService;


	@GetMapping("index")
    public String getIndexPage() {
        List<Film> films = filmService.getMovies(0, 20);
        System.out.println("get page");
        return "index";
    }

}
