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
 * 电影类型类
 */
@Entity
@Table(name = "FilmType")
public class FilmType {

	private int typeId; // 类型id
	private String name; // 类型名
	private Set<Film> films; // 符合该类型的电影集合

	public FilmType() {
	}

	public FilmType(String name) {
		this.name = name;
	}

	@Id
	@Column(name = "typeId", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
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
	@JoinTable(name="HasType", joinColumns=@JoinColumn(name="typeId"), inverseJoinColumns=@JoinColumn(name="filmId"))
	public Set<Film> getFilms() {
		return films;
	}

	public void setFilms(Set<Film> films) {
		this.films = films;
	}

	@Override
	public String toString() {
		return "FilmType [typeId=" + typeId + ", name=" + name + "]";
	}

}
