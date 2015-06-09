package com.zhbit.dao;

import com.zhbit.domain.Users;

/*
 * @author HuangLongChang
 */
public interface UserDao {

	public Users getLogin(String name, String password);

	public void savaUser(Users user);

	public Users getUserByName(String name);

	public void upDatePassword(String name, String password);

}
