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

    // TODO: 2017/6/3 测试完改回 get 方法 , 改回按照参数获取信息
//    @PostMapping("/movie/results")
    @GetMapping("/movie/results")
    public String creatOrder(
//            @RequestParam("phone") String phone,
//                             @SessionAttribute("seatIndexList")LinkedList<String> seatIndexList,
//                             @SessionAttribute("playSessionId") Integer playSessionId,
                             Model model) {

        // TODO: 2017/6/2 测试完删掉
        LinkedList<String> seatIndexList = null;
        Integer playSessionId =1;
        seatIndexList = new LinkedList<String>();
        seatIndexList.add("1,2");
        seatIndexList.add("1,3");
        seatIndexList.add("1,4");
        seatIndexList.add("1,5");
        String phone = "15521155847";
        // test sample end


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
