package com.skid.skidtoy.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestDao {
	
	@Autowired
	private SqlSession session;
	
	public List<String> testMethod() {
		System.out.println("@@@@@@@@@@");
		return session.selectList("com.testMapper.selTestData");
	}
}
