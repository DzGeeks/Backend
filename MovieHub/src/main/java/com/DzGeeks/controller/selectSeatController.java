package com.DzGeeks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by user on 2017/5/25.
 */

@Controller
public class selectSeatController {

    @GetMapping("/selectSeat")
    public String getSeatPage() {
        return "selectSeat";
    }
}
