package com.shawn.demo.business.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shawn.demo.business.model.Test;
import com.shawn.demo.business.TestService;
import com.shawn.demo.persistance.TestDAO;
import com.shawn.demo.persistance.UserDAO;


@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private TestDAO testDao;
	@Autowired
	private UserDAO userDao;


	@Transactional( readOnly =false,rollbackFor=Exception.class)
	@Override
	public Test createTest(Test test) {
		userDao.delete(100000);
		Long id  = testDao.create(test);
		test.setId(id);
		return test;
	}

}
