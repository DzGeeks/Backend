package com.DzGeeks.repository.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/*
 * 演员类
 */
@Entity
@Table(name = "Actor")
public class Actor {

	private int actorId; // 演员id
	private String name; // 演员姓名
	private Set<Film> films; // 该演员参演的电影集合

	public Actor() {
	}

	public Actor(String name) {
		this.name = name;
	}

	@Id
	@Column(name = "actorId", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getActorId() {
		return actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	@Column(name = "name", nullable = false, length = 45)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany
	@Cascade(value = CascadeType.SAVE_UPDATE)
	//指定中间表
	@JoinTable(name="ActIn", joinColumns=@JoinColumn(name="actorId"), inverseJoinColumns=@JoinColumn(name="filmId"))
	public Set<Film> getFilms() {
		return films;
	}

	public void setFilms(Set<Film> films) {
		this.films = films;
	}

	@Override
	public String toString() {
		return "Actor [actorId=" + actorId + ", name=" + name + "]";
	}

}
