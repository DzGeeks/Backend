package com.DzGeeks.repository.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * 场次类
 */
@Entity
@Table(name = "PlaySession")
public class PlaySession {
	private int playSessionId; // 场次id
	private int filmId; // 电影id
	private Date date; // 放映日期
	private String startTime; // 开始时间
	private String endTime; // 结束时间
	private String language; // 电影语言
	private double price; // 票价
	private String roomId; // 影厅id
	private int cinemaId; // 电影院id
	private int dimension; // 维度 2D/3D
	private double discount; // 折扣

	public PlaySession() {
	}

	public PlaySession(int filmId, Date date, String startTime, String endTime, String language, double price,
			String roomId, int cinemaId, int dimension, double discount) {
		this.filmId = filmId;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.language = language;
		this.price = price;
		this.roomId = roomId;
		this.cinemaId = cinemaId;
		this.dimension = dimension;
		this.discount = discount;
	}

	@Id
	@Column(name = "playSessionId", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getPlaySessionId() {
		return playSessionId;
	}

	public void setPlaySessionId(int playSessionId) {
		this.playSessionId = playSessionId;
	}

	@Column(name = "filmId", nullable = false)
	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	@Column(name = "date", nullable = false)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "startTime", nullable = false, length = 45)
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	@Column(name = "endTime", nullable = false, length = 45)
	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@Column(name = "language", nullable = false, length = 45)
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Column(name = "price", nullable = false)
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Column(name = "roomId", nullable = false, length = 45)
	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	@Column(name = "cinemaId", nullable = false)
	public int getCinemaId() {
		return cinemaId;
	}

	public void setCinemaId(int cinemaId) {
		this.cinemaId = cinemaId;
	}

	@Column(name = "dimension", nullable = false)
	public int getDimension() {
		return dimension;
	}

	public void setDimension(int dimension) {
		this.dimension = dimension;
	}

	@Column(name = "discount", nullable = false)
	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "PlaySession [playSessionId=" + playSessionId + ", filmId=" + filmId + ", date=" + date + ", startTime="
				+ startTime + ", endTime=" + endTime + ", language=" + language + ", price=" + price + ", roomId="
				+ roomId + ", cinemaId=" + cinemaId + ", dimension=" + dimension + ", discount=" + discount + "]";
	}

}
