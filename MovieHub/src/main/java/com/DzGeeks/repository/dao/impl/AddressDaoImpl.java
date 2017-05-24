package com.DzGeeks.repository.dao.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.DzGeeks.repository.dao.AddressDao;
import com.DzGeeks.repository.entity.Address;
import com.DzGeeks.util.DBSessionUtil;

@Repository
public class AddressDaoImpl implements AddressDao {
	
	//增
	public void addAddress(Address a) {
		Session session = DBSessionUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(a);
		session.getTransaction().commit();
		session.close();
	}
	
	//根据id获取地址
	public Address getAddress(int id) {
		Session session = DBSessionUtil.getSessionFactory().openSession();
		Address a = (Address) session.get(Address.class, id);
		session.close();
		return a;
	}
}
