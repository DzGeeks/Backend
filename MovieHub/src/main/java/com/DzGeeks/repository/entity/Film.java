package com.DzGeeks.repository.entity;

import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.context.annotation.Lazy;

/*
 * 电影类
 */
@Entity
@Table(name = "Film")
public class Film {

	private int filmId; // 电影id
	private String name; // 电影名
	private double score; // 评分
	private int duration; // 时长
	private int year; // 上映年度
	private String director; // 导演名字
	private String description; // 电影描述
	private Set<Actor> actors; // 演员集合
	private Set<FilmType> filmTypes; // 电影类型集合

	public Film() {
	}

	public Film(String name, double score, int duration, int year, String director, String description) {
		this.name = name;
		this.score = score;
		this.duration = duration;
		this.year = year;
		this.director = director;
		this.description = description;
	}

	@Id
	@Column(name = "filmId", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	@Column(name = "name", nullable = false, length = 45)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "score", nullable = false)
	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Column(name = "duration", nullable = false)
	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Column(name = "year", nullable = false)
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Column(name = "director", nullable = false, length = 45)
	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	@Column(name = "description", nullable = false, length = 200)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@Cascade(value = CascadeType.SAVE_UPDATE)
	// 指定中间表
	@JoinTable(name = "ActIn", joinColumns = @JoinColumn(name = "filmId"), inverseJoinColumns = @JoinColumn(name = "actorId"))
	public Set<Actor> getActors() {
		return actors;
	}

	public void setActors(Set<Actor> actors) {
		this.actors = actors;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@Cascade(value = CascadeType.SAVE_UPDATE)
	// 指定中间表
	@JoinTable(name = "HasType", joinColumns = @JoinColumn(name = "filmId"), inverseJoinColumns = @JoinColumn(name = "typeId"))
	public Set<FilmType> getFilmTypes() {
		return filmTypes;
	}

	public void setFilmTypes(Set<FilmType> filmTypes) {
		this.filmTypes = filmTypes;
	}

	@Override
	public String toString() {
		return "Film [filmId=" + filmId + ", name=" + name + ", score=" + score + ", duration=" + duration + ", year="
				+ year + ", director=" + director + ", description=" + description + "]";
	}

}
