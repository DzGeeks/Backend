package com.DzGeeks.controller;

import com.DzGeeks.business.CinemaService;
import com.DzGeeks.business.FilmService;
import com.DzGeeks.business.OrderService;
import com.DzGeeks.business.PlaySessionService;
import com.DzGeeks.repository.entity.Cinema;
import com.DzGeeks.repository.entity.Film;
import com.DzGeeks.repository.entity.PlaySession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by user on 2017/6/2.
 */

@Controller
@SessionAttributes({"playSessionId", "seatIndexList"})
public class MovieOrderController {

    @Autowired
    PlaySessionService playSessionService;
    @Autowired
    FilmService filmService;
    @Autowired
    CinemaService cinemaService;

    @PostMapping("/movie/order")
    public String confirmOrder(
            @RequestParam(value = "seatIndexList", required = false)LinkedList<String> seatIndexList,
                               @SessionAttribute(value = "playSessionId", required = false) Integer playSessionId,
                               Model model) {

        PlaySession thisPlaySession = playSessionService.selectPlaySession(playSessionId);
        Film thisFilm = filmService.getOneMovie(thisPlaySession.getFilmId());
        Cinema thisCinema = cinemaService.getCinema(thisPlaySession.getCinemaId());

        ArrayList<String> priceInfos = new ArrayList<String>();

        // 购票信息，价格
        // 票数 + 单票价格 1 + 单票价格 2 + ... + 总价（最后）
        priceInfos.add("" + seatIndexList.size()); //购票数
        priceInfos.add(thisPlaySession.getPrice() + ""); // 单票价格
        priceInfos.add("" + thisPlaySession.getPrice() * seatIndexList.size() ); // 总价

        model.addAttribute("thisPlaySession", thisPlaySession);
        model.addAttribute("thisFilm", thisFilm);
        model.addAttribute("thisCinema", thisCinema);
        model.addAttribute("seatIndexList", seatIndexList);
        model.addAttribute("priceInfos", priceInfos);

        return "order";
    }
}
