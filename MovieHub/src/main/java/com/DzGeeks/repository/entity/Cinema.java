package com.DzGeeks.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * 电影院类
 */
@Entity
@Table(name = "Cinema")
public class Cinema {

	private int cinemaId; // 电影院id
	private String name; // 电影院名字
	private int addressId; // 电影院地址id
	private String phone; // 电影院联系电话

	public Cinema() {
	}

	public Cinema(String name, int addressId, String phone) {
		this.name = name;
		this.addressId = addressId;
		this.phone = phone;
	}

	public Cinema(int cinemaId, String name, int addressId, String phone) {
		this.cinemaId = cinemaId;
		this.name = name;
		this.addressId = addressId;
		this.phone = phone;
	}

	@Id
	@Column(name = "cinemaId", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getCinemaId() {
		return cinemaId;
	}

	public void setCinemaId(int cinemaId) {
		this.cinemaId = cinemaId;
	}

	@Column(name = "name", nullable = false, length = 200)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="addressId", nullable = false)
	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	@Column(name = "phone", nullable = false, length = 45)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Cinema [cinemaId=" + cinemaId + ", name=" + name + ", addressId=" + addressId + ", phone=" + phone
				+ "]";
	}

}
