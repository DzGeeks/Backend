package com.DzGeeks.controller;

import com.DzGeeks.business.CinemaService;
import com.DzGeeks.business.FilmService;
import com.DzGeeks.business.PlaySessionService;
import com.DzGeeks.repository.entity.Actor;
import com.DzGeeks.repository.entity.Cinema;
import com.DzGeeks.repository.entity.Film;
import com.DzGeeks.repository.entity.PlaySession;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by user on 2017/5/25.
 */

@Controller
@RequestMapping("/movie")
public class movieDetailController {

    @Autowired
    FilmService filmService;
    @Autowired
    CinemaService cinemaService;
    @Autowired
    PlaySessionService playSessionService;

    @GetMapping("/detail")
    public String getMovieDetail(@RequestParam("filmId") int filmId,
                                 Model model) throws ParseException {

        Film thisFilm = filmService.getOneMovie(filmId);
        Set<Actor> actorSet = thisFilm.getActors();

        List<Cinema> cinemaList = cinemaService.getCinemas(filmId);
        // 放映日期
        HashMap<String, HashMap<String, List>> dataForThisFilm = new HashMap<String, HashMap<String, List>>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (Cinema oneCinema : cinemaList) {
            List<PlaySession> playSessionList = playSessionService.getPlayingSessions(filmId, oneCinema.getCinemaId());

            for (PlaySession oneSession : playSessionList) {
                String dataStr = simpleDateFormat.format(oneSession.getDate()); //解析出日期 ：yyyy-MM-dd

                if (dataForThisFilm.get(dataStr) != null) {
                    HashMap sessionOneDay = dataForThisFilm.get(dataStr);
                    List<PlaySession> sessionOneDayInThisCinema = (List<PlaySession>) sessionOneDay.get(oneCinema.getName());
                    if (sessionOneDayInThisCinema != null) {
                        sessionOneDayInThisCinema.add(oneSession);
                    } else {
                        List<PlaySession> newSessionListInThisCinemaInThisDay = new LinkedList<PlaySession>();
                        newSessionListInThisCinemaInThisDay.add(oneSession);
                        sessionOneDay.put(oneCinema.getName(), newSessionListInThisCinemaInThisDay);
                    }
                } else {
                    Map<String, List> newDataForThisFilm = new HashMap<String, List>();
                    List<PlaySession> sessionList = new LinkedList<PlaySession>();
                    sessionList.add(oneSession);
                    newDataForThisFilm.put(oneCinema.getName(), sessionList);
                    dataForThisFilm.put(dataStr, (HashMap<String, List>) newDataForThisFilm);
                }
            }

        }

        //
        model.addAttribute("thisFilm", thisFilm);
        model.addAttribute("dataForThisFilm", dataForThisFilm);


        return "moviedetail";
    }
}
