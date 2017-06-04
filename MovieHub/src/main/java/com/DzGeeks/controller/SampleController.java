package com.DzGeeks.controller;

import com.DzGeeks.business.CinemaService;
import com.DzGeeks.business.FilmService;
import com.DzGeeks.business.SeatService;
import com.DzGeeks.repository.dao.*;
import com.DzGeeks.repository.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by user on 2017/6/4.
 */

@Controller
public class SampleController {

    @Autowired
    FilmDao filmDao;
    @Autowired
    ActorDao actorDao;
    @Autowired
    CinemaDao cinemaDao;
    @Autowired
    PlaySessionDao playSessionDao;
    @Autowired
    SeatDao seatDao;
    @Autowired
    FilmTypeDao filmTypeDao;
    @Autowired
    AddressDao addressDao;


    @GetMapping("/createSamples")
    public String createSamples() throws ParseException {
        createCinema_Address();
        createFilms_Actor_Type();
        createPlaySession();
        createSeat();
        return "index";
    }

    private void createSeat() {
        Seat seat_1 = new Seat(1, 4, 10, "SSSS1SSSSS" + "SSSSSSSSSS" + "SSSSSSSSSS" + "SSEESSEESS");
        seat_1.setSeatId(1);
        Seat seat_2 = new Seat(2, 4, 10, "SSSS1S1SSS" + "SSSSSSSSSS" + "SSSSSSSSSS" + "SSEESSEESS");
        seat_2.setSeatId(1);
        Seat seat_3 = new Seat(3, 4, 10, "SSSS1SSSSS" + "SSSSEESSSS" + "SSSSSSSSSS" + "EEEESSEESS");
        seat_3.setSeatId(1);
        Seat seat_4 = new Seat(4, 4, 10, "SSSSSSSSSS" + "EESSSSSSEE" + "SSSEEEESSS" + "SSEESSEESS");
        seat_4.setSeatId(1);
        Seat seat_5 = new Seat(5, 4, 10, "SSSSSSSSSS" + "SSSSEESSSS" + "SSSSEESSSS" + "SSEEEEEESS");
        seat_5.setSeatId(1);
        Seat seat_6 = new Seat(6, 4, 10, "SSSS1SSSSS" + "SSSSSSSSSS" + "SSSSSSSSSS" + "SSEESSEESS");
        seat_6.setSeatId(1);

        seatDao.addSeat(seat_1);
        seatDao.addSeat(seat_2);
        seatDao.addSeat(seat_3);
        seatDao.addSeat(seat_4);
        seatDao.addSeat(seat_5);
        seatDao.addSeat(seat_6);
    }

    private void createPlaySession() throws ParseException {
        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 1
        String dataStr_1 = "2017-06-12 15:12:12";
        PlaySession playSession_1 = new PlaySession(3, dataFormat.parse(dataStr_1), "12:00", "15:00", "英语", 30,
                "5号厅", 1, 3, 9.5);
        playSession_1.setPlaySessionId(1);

        // 2
        PlaySession playSession_2 = new PlaySession(3, dataFormat.parse(dataStr_1), "12:00", "15:00", "英语", 30,
                "5号厅", 2, 3, 9.5);
        playSession_2.setPlaySessionId(2);

        // 3
        PlaySession playSession_3 = new PlaySession(4, dataFormat.parse(dataStr_1), "12:00", "15:00", "英语", 30,
                "5号厅", 3, 2, 9.5);
        playSession_3.setPlaySessionId(3);


        //-----------下一个时间段

        // 4
        String dataStr_2 = "2017-06-13 15:12:12";
        PlaySession playSession_4 = new PlaySession(3, dataFormat.parse(dataStr_2), "12:00", "15:00", "英语", 30,
                "5号厅", 3, 3, 9.5);
        playSession_4.setPlaySessionId(4);

        // 5
        PlaySession playSession_5 = new PlaySession(4, dataFormat.parse(dataStr_2), "12:00", "15:00", "英语", 30,
                "5号厅", 4, 3, 9.5);
        playSession_5.setPlaySessionId(5);

        // 6
        PlaySession playSession_6 = new PlaySession(3, dataFormat.parse(dataStr_2), "12:00", "15:00", "英语", 30,
                "5号厅", 5, 3, 9.5);
        playSession_6.setPlaySessionId(6);

        playSessionDao.addPlaySession(playSession_1);
        playSessionDao.addPlaySession(playSession_2);
        playSessionDao.addPlaySession(playSession_3);
        playSessionDao.addPlaySession(playSession_4);
        playSessionDao.addPlaySession(playSession_5);
        playSessionDao.addPlaySession(playSession_6);

    }

    private void createCinema_Address() {
        Cinema cinema_1 = new Cinema(1, "哈艺时尚影城(石榴岗路店)", 1, "15555555551");
        Cinema cinema_2 = new Cinema(2, "金逸珠江影城（大学城店）", 2, "15555555552");
        Cinema cinema_3 = new Cinema(3, "广州飞扬影城（正佳IMAX店）", 3, "15555555553");
        Cinema cinema_4 = new Cinema(4, "广州保利国际影城（中环店）", 4, "15555555554");
        Cinema cinema_5 = new Cinema(5, "广州五一影城（四季天地店）", 5, "15555555555");


        Address address_1 = new Address("广州", "天河区");
        address_1.setAddressId(1);
        Address address_2 = new Address("广州", "番禺区");
        address_1.setAddressId(2);
        Address address_3 = new Address("广州", "天河区");
        address_1.setAddressId(3);
        Address address_4 = new Address("广州", "海珠区");
        address_1.setAddressId(4);
        Address address_5 = new Address("广州", "越秀区");
        address_1.setAddressId(5);

        cinemaDao.addCinema(cinema_1);
        cinemaDao.addCinema(cinema_2);
        cinemaDao.addCinema(cinema_3);
        cinemaDao.addCinema(cinema_4);
        cinemaDao.addCinema(cinema_5);

        addressDao.addAddress(address_1);
        addressDao.addAddress(address_2);
        addressDao.addAddress(address_3);
        addressDao.addAddress(address_4);
        addressDao.addAddress(address_5);
    }

    public void createFilms_Actor_Type() {
        Film film_1 = new Film("摔跤吧爸爸", 9.5, 120, 2017,
                "youngdou", "这是一个温暖幽默的励志故事。马哈维亚辛格珀尕（阿米尔汗饰）曾是印度国家摔跤冠军，因生活所迫放弃摔跤。他希望让儿子可以帮他完成梦想——赢得世界级金牌。结果生了四个女儿本以为梦想就此破碎的辛格却意外发现女儿身上的惊人天..");

        film_1.setFilmId(1);

        Set<Actor> actorSet_1 = new HashSet<Actor>();
        Actor actor_1 = new Actor("周星驰");
        Actor actor_2 = new Actor("吴孟达");
        actorSet_1.add(actor_1);
        actorSet_1.add(actor_2);

        Set<FilmType> typeSet_1 = new HashSet<FilmType>();
        FilmType filmType_1 = new FilmType("动作");
        FilmType filmType_2 = new FilmType("悬疑");
        typeSet_1.add(filmType_1);
        typeSet_1.add(filmType_2);

        film_1.setActors(actorSet_1);
        film_1.setFilmTypes(typeSet_1);

        // filmId = 2
        Film film_2 = new Film("哆啦A梦：大雄的南极冰冰凉大冒险", 6.7, 132, 2016,
                "youngdou_2", "夏天来了，经不住大雄的百般纠缠，哆啦A梦第一次同意带着小伙伴们来到南极，并建造了专属的南极乐园。没想到这场消夏之旅，被偶然发现的金环打断，快乐的旅程就此中止，他们来到十万年前的南极。这一次，哆啦A梦面临生死考验，地球也面..");
        film_2.setFilmId(2);

        Set<Actor> actorSet_2 = new HashSet<Actor>();
        Actor actor_3 = new Actor("不二雄");
        Actor actor_4 = new Actor("藤原拓海");
        actorSet_1.add(actor_3);
        actorSet_1.add(actor_4);

        Set<FilmType> typeSet_2 = new HashSet<FilmType>();
        FilmType filmType_3 = new FilmType("喜剧");
        FilmType filmType_4 = new FilmType("动漫");
        typeSet_2.add(filmType_3);
        typeSet_2.add(filmType_4);

        film_2.setActors(actorSet_2);
        film_2.setFilmTypes(typeSet_2);

        filmDao.addFilm(film_1);
        filmDao.addFilm(film_2);

        actorDao.addActor(actor_1);
        actorDao.addActor(actor_2);
        actorDao.addActor(actor_3);
        actorDao.addActor(actor_4);

        filmTypeDao.addFilmType(filmType_1);
        filmTypeDao.addFilmType(filmType_2);
        filmTypeDao.addFilmType(filmType_3);
        filmTypeDao.addFilmType(filmType_4);
    }

}
