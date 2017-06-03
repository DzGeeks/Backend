package com.DzGeeks.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * 座位类
 */
@Entity
@Table(name = "Seat")
public class Seat {

	private int seatId; // 座位id
	private int playSessionId; // 场次id
	private int myrow; // 行
	private int mycolumn; // 列
	private String status; // 座位01表，表示空位与否

	public Seat() {
	}

	public Seat(int playSessionId, int row, int column, String status) {
		this.playSessionId = playSessionId;
		this.myrow = row;
		this.mycolumn = column;
		this.status = status;
	}

	@Id
	@Column(name = "seatId", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	@Column(name = "playSessionId", nullable = false)
	public int getPlaySessionId() {
		return playSessionId;
	}

	public void setPlaySessionId(int playSessionId) {
		this.playSessionId = playSessionId;
	}

	@Column(name = "myrow", nullable = false)
	public int getRow() {
		return myrow;
	}

	public void setRow(int row) {
		this.myrow = row;
	}

	@Column(name = "mycolumn", nullable = false)
	public int getColumn() {
		return mycolumn;
	}

	public void setColumn(int column) {
		this.mycolumn = column;
	}

	@Column(name = "status", nullable = false, length = 200)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Seat [seatId=" + seatId + ", playSessionId=" + playSessionId + ", myrow=" + myrow + ", column="
				+ mycolumn + ", status=" + status + "]";
	}

}
