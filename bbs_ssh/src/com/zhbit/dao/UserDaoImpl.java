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
		System.out.println("������ò�ѯ�û������û�������");

		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		if (query.uniqueResult() != null) {
			System.out.println("���ò�ѯ�û������û������ѯ�н��");
			user = (Users) query.uniqueResult();

		}
		System.out.println("���ؽ��");
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
		System.out.println("��������������û�");
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		System.out.println("������ø����������û�");
		if (query.uniqueResult() != null) {
			System.out.println("���ø����������û����н��");
			user = (Users) query.uniqueResult();
		}
		System.out.println("���ø����������û�");
		return user;
	}

	@Override
	public void upDatePassword(String name, String password) {
		// TODO Auto-generated method stub
		String hql = "update Users user set user.password='" + password
				+ "' where user.name='" + name + "'";
		System.out.println(hql);
		System.out.println("�����������Dao");

		/*
		 * if(session==null) { System.out.println("jb1"); }
		 */

		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		int i = query.executeUpdate();
		System.out.println("����Ӱ����Ŀ=" + i);

	}

}
