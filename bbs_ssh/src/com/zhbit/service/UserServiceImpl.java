/**
 * 
 */
package com.zhbit.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zhbit.dao.UserDao;
import com.zhbit.domain.Users;



@Transactional
public class UserServiceImpl implements UserService {

	@Resource
	UserDao userDao;

	@Override
	public Users getLogin(String name, String password) {
		// TODO Auto-generated method stub
	
		return  	userDao.getLogin(name, password);
	}

	@Override
	public void addUser(Users user) {
		// TODO Auto-generated method stub
		
        userDao.savaUser(user);
	}

	@Override
	public Users getUserByName(String name) {
		
		// TODO Auto-generated method stub
		return userDao.getUserByName(name);
	}

	@Override
	public void upDatePassword(String name, String password) {
		// TODO Auto-generated method stub
		userDao.upDatePassword(name,password);
	}


    

}
