/**
 * 
 */
package com.zhbit.service;

import java.util.List;

import com.zhbit.domain.Users;



/**
 * @author Administrator
 * 
 */
public interface UserService {

	public Users getLogin(String name,String password);
	/*public Users insertUser(Users user);

	public Users updateUser(Users user);

	public void deleteUser(Users user);

	public List searchUser(String whereSql);*/
	public Users getUserByName(String name);
	public void addUser(Users user);
	public void upDatePassword(String name, String password);
	
}
