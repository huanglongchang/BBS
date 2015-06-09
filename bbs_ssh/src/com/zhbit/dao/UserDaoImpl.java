/**
 * 
 */
package com.zhbit.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zhbit.domain.Users;

/**
 * @author Administrator
 * 
 */
public class UserDaoImpl implements UserDao {
	@Resource
	private SessionFactory sessionFactory;

	public Users getLogin(String name, String password) {
		Users user = null;
		String hql = "from Users where name='" + name + "' and password='"
				+ password + "'";
		System.out.println(hql);
		System.out.println("进入调用查询用户根据用户名密码");

		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		if (query.uniqueResult() != null) {
			System.out.println("调用查询用户根据用户密码查询有结果");
			user = (Users) query.uniqueResult();

		}
		System.out.println("返回结果");
		return user;
	}

	@Override
	public void savaUser(Users user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public Users getUserByName(String name) {
		// TODO Auto-generated method stub
		Users user = null;

		String hql = "from Users where name='" + name + "'";
		System.out.println(hql);
		System.out.println("进入根据姓名查用户");
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		System.out.println("进入调用根据姓名查用户");
		if (query.uniqueResult() != null) {
			System.out.println("调用根据姓名查用户，有结果");
			user = (Users) query.uniqueResult();
		}
		System.out.println("调用根据姓名查用户");
		return user;
	}

	@Override
	public void upDatePassword(String name, String password) {
		// TODO Auto-generated method stub
		String hql = "update Users user set user.password='" + password
				+ "' where user.name='" + name + "'";
		System.out.println(hql);
		System.out.println("进入更新密码Dao");

		/*
		 * if(session==null) { System.out.println("jb1"); }
		 */

		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		int i = query.executeUpdate();
		System.out.println("更新影响条目=" + i);

	}

}
