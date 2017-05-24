package com.DzGeeks.repository.dao;

import com.DzGeeks.repository.entity.Address;

public interface AddressDao {

	//增
	public void addAddress(Address a);
	
	//根据id获取地址
	public Address getAddress(int id);
}
