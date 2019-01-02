package com.skid.skidtoy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skid.skidtoy.service.TestService;

@Service
public class TestServiceImpl implements TestService{

	@Autowired
	private TestDao dao;
	
	@Override
	public List<String> selTestData() throws Exception {
		return dao.testMethod();
	}

}
