package com.DzGeeks.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DzGeeks.business.AddressService;
import com.DzGeeks.repository.dao.impl.AddressDaoImpl;
import com.DzGeeks.repository.entity.Address;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDaoImpl addressDao;

	// 根据id获取地址
	public Address getAddress(int addressId) {
		return addressDao.getAddress(addressId);
	}

}
