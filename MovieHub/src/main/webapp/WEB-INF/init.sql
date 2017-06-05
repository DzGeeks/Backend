
insert into seat (playSessionId, myrow, mycolumn, status) 
	values(1, 4, 10, "SSSS1SSSSSSSSSSSSSSSSSSSSSSSSSSSEESSEESS");
insert into seat (playSessionId, myrow, mycolumn, status) 
	values(2, 4, 10, "SSSS1S1SSSSSSSSSSSSSSSSSSSSSSSSSEESSEESS");
insert into seat (playSessionId, myrow, mycolumn, status) 
	values(3, 4, 10, "SSSS1SSSSSSSSSEESSSSSSSSSSSSSSEEEESSEESS");
insert into seat (playSessionId, myrow, mycolumn, status) 
	values(4, 4, 10, "SSSSSSSSSSEESSSSSSEESSSEEEESSSSSEESSEESS");
insert into seat (playSessionId, myrow, mycolumn, status) 
	values(5, 4, 10, "SSSSSSSSSSSSSSEESSSSSSSSEESSSSSSEEEEEESS");
insert into seat (playSessionId, myrow, mycolumn, status) 
	values(6, 4, 10, "SSSS1SSSSSSSSSSSSSSSSSSSSSSSSSSSEESSEESS");

insert into playSession (playSessionId, filmId, date, startTime, endTime, language, price, roomId, cinemaId, dimension, discount)
	values(1, 1, '2017-06-12 00:00:00', "12:00", "15:00", "英语", 30, "5号厅", 1, 3, 9.5);
insert into playSession (playSessionId, filmId, date, startTime, endTime, language, price, roomId, cinemaId, dimension, discount)
	values(2, 1, '2017-06-12 00:00:00', "12:00", "15:00", "英语", 30, "5号厅", 2, 3, 9.5);
insert into playSession (playSessionId, filmId, date, startTime, endTime, language, price, roomId, cinemaId, dimension, discount)
	values(3, 2, '2017-06-12 00:00:00', "12:00", "15:00", "国语", 30,"5号厅", 3, 2, 8.6);
insert into playSession (playSessionId, filmId, date, startTime, endTime, language, price, roomId, cinemaId, dimension, discount)
	values(4, 1, '2017-06-13 00:00:00', "12:00", "15:00", "国语", 30,"5号厅", 3, 3, 8.6);
insert into playSession (playSessionId, filmId, date, startTime, endTime, language, price, roomId, cinemaId, dimension, discount)
	values(5, 2, '2017-06-13 00:00:00', "12:00", "15:00", "英语", 30,"5号厅", 4, 3, 8.6);
insert into playSession (playSessionId, filmId, date, startTime, endTime, language, price, roomId, cinemaId, dimension, discount)
	values(6, 1, '2017-06-13 00:00:00', "12:00", "15:00", "英语", 30,"5号厅", 5, 3, 9.5);


insert into cinema (cinemaId, name, addressId, phone)
	values(1, "哈艺时尚影城(石榴岗路店)", 1, "15555555551");
insert into cinema (cinemaId, name, addressId, phone)
	values(2, "金逸珠江影城（大学城店）", 2, "15555555552");
insert into cinema (cinemaId, name, addressId, phone)
	values(3, "广州飞扬影城（正佳IMAX店）", 3, "15555555553");
insert into cinema (cinemaId, name, addressId, phone)
	values(4, "广州保利国际影城（中环店）", 4, "15555555554");
insert into cinema (cinemaId, name, addressId, phone)
	values(5, "广州五一影城（四季天地店）", 5, "15555555555");


insert into address (addressId, city, district)
	values(1, "广州", "天河区");
insert into address (addressId, city, district)
	values(2, "广州", "番禺区");
insert into address (addressId, city, district)
	values(3, "广州", "天河区");
insert into address (addressId, city, district)
	values(4, "广州", "海珠区");
insert into address (addressId, city, district)
	values(5, "广州", "越秀区");
        
 
insert into actor(actorId, name)
	values(1, "周星驰");
insert into actor(actorId, name)
	values(2, "吴孟达");
insert into actor(actorId, name)
	values(3, "不二雄");
insert into actor(actorId, name)
	values(4, "藤原拓海");


insert into filmType values(1, "喜剧");
insert into filmType values(2, "惊悚");
insert into filmType values(3, "动作");
insert into filmType values(4, "悬疑");


insert into film (filmId, name, score, duration, year, director, description) 
	values(1, "摔跤吧爸爸", 9.5, 120, 2017, "youngdou", "这是一个温暖幽默的励志故事。马哈维亚辛格珀尕（阿米尔汗饰）曾是印度国家摔跤冠军，因生活所迫放弃摔跤。他希望让儿子可以帮他完成梦想——赢得世界级金牌。结果生了四个女儿本以为梦想就此破碎的辛格却意外发现女儿身上的惊人天..");
insert into film (filmId, name, score, duration, year, director, description) 
	values(2, "哆啦A梦：大雄的南极冰冰凉大冒险", 6.7, 132, 2016, "youngdou_2", "夏天来了，经不住大雄的百般纠缠，哆啦A梦第一次同意带着小伙伴们来到南极，并建造了专属的南极乐园。没想到这场消夏之旅，被偶然发现的金环打断，快乐的旅程就此中止，他们来到十万年前的南极。这一次，哆啦A梦面临生死考验，地球也面.." );


insert into actin(filmId, actorId)
	values(1, 1);
insert into actin(filmId, actorId)
	values(1, 2);
insert into actin(filmId, actorId)
	values(2, 3);
insert into actin(filmId, actorId)
	values(2, 4);


insert into hasType(filmId, typeId)
	values(1, 1);
insert into hasType(filmId, typeId)
	values(1, 2);
insert into hasType(filmId, typeId)
	values(2, 3);
insert into hasType(filmId, typeId)
	values(2, 4);




        









