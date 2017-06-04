package com.DzGeeks.controller;

import com.DzGeeks.business.PlaySessionService;
import com.DzGeeks.business.SeatService;
import com.DzGeeks.repository.entity.PlaySession;
import com.DzGeeks.repository.entity.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by user on 2017/5/25.
 */

@Controller
@SessionAttributes("playSessionId")
public class MovieSeatController {

    @Autowired
    SeatService seatService;
    @Autowired
    PlaySessionService playSessionService;

    @GetMapping("/movie/seat")
    public String getSeatPage(@RequestParam("playSessionId") Integer playSessionId,
                              Model model) {

        PlaySession playSession = playSessionService.selectPlaySession(playSessionId);

        Seat seat = seatService.getSeats(playSessionId);
        //构造座位的二维数组
        ArrayList<ArrayList<ArrayList<Character>>> seatMatrx = new ArrayList();
        String SeatStr = seat.getStatus();
        for (int row = 0; row < seat.getRow(); row++) {
            ArrayList<ArrayList<Character>> oneRowSaet = new ArrayList<ArrayList<Character>>();
            for (int col = 0; col < seat.getColumn(); col++) {
                // 示例:
                // 0 1 2 3
                // 4 5 6 7
                ArrayList<Character> seatInfo = new ArrayList<Character>();

                // 行 + 列 + 座位状态
                seatInfo.add(("" + (row + 1)).charAt(0));
                seatInfo.add(("" + (col + 1)).charAt(0));
                seatInfo.add(SeatStr.charAt(row * seat.getColumn() + col));

                oneRowSaet.add(seatInfo);
            }
            seatMatrx.add(oneRowSaet);
        }

        LinkedList<Integer> rowNums = new LinkedList<Integer>();
        for (int i = 1; i <= seat.getRow(); i++) {
            rowNums.add(i);
        }
        model.addAttribute("rowNums", rowNums);
        model.addAttribute("seatMatrx", seatMatrx);
        model.addAttribute("playSessionId", playSessionId);
        model.addAttribute("playSession", playSession);
        return "selectSeat";
    }
}
