package com.DzGeeks.controller;

import com.DzGeeks.business.*;
import com.DzGeeks.repository.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;

/**
 * Created by user on 2017/6/3.
 */

@Controller
@SessionAttributes({"seatIndexList", "playSessionId"})
public class FinishOrderController {


    @Autowired
    OrderService orderService;
    @Autowired
    SeatService seatService;
    @Autowired
    FilmService filmService;
    @Autowired
    CinemaService cinemaService;
    @Autowired
    PlaySessionService playSessionService;

    @PostMapping("/movie/results")
    // TODO: 2017/6/3 测试完改回 get 方法 , 改回按照参数获取信息
    public String creatOrder(
            @RequestParam("email") String email,
            @RequestParam("phone") String phone,
                             @SessionAttribute("seatIndexList")LinkedList<String> seatIndexList,
                             @SessionAttribute("playSessionId") Integer playSessionId,
                             Model model) {

        Seat thisSeat = seatService.getSeats(playSessionId);
        Integer orderId = null;
        for (String one_seat : seatIndexList) {
            int row = Integer.parseInt(one_seat.charAt(0) + "");
            int col = Integer.parseInt(one_seat.charAt(2) + "");
            Integer ont_seat_index = thisSeat.getColumn() * ( row - 1 ) + ( col - 1 );
            orderId = orderService.createOrderItem(phone, playSessionId, ont_seat_index);
        }

        Order order = orderService.getOrder(orderId);
        PlaySession thisPlaySession = playSessionService.selectPlaySession(playSessionId);
        Cinema thisCinema = cinemaService.getCinema(thisPlaySession.getCinemaId());
        Film thisFilm = filmService.getOneMovie(thisPlaySession.getFilmId());
        model.addAttribute("thisCinema", thisCinema);
        model.addAttribute("order", order);
        model.addAttribute("thisPlaySession", thisPlaySession);
        model.addAttribute("seatIndexList", seatIndexList);
        model.addAttribute("thisFilm", thisFilm);

        return "finishOrder";
    }
}
