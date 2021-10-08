package com.douzone.emaillist.dao.test;

import java.sql.Connection;

import com.douzone.emaillist.dao.EmaillistDao;
import com.douzone.emaillist.vo.EmaillistVo;

import util.SimpleConnectionProvider;

public class EmaillistDaoTest {
	private static EmaillistDao dao = new EmaillistDao(new SimpleConnectionProvider());
	public static void main(String[] args) {
//		insertTest();
		findAllTest();
	}

	private static void findAllTest() {
		dao.findAll().forEach(System.out::println);
	}

	private static void insertTest() {
		EmaillistVo email = new EmaillistVo();
		email.setFirstName("마");
		email.setLastName("이콜");
		email.setEmail("michol@gmail.om");
		
		dao.insert(email);
	}
	
}
