package com.zhbit.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.zhbit.domain.Message;
import com.zhbit.domain.Post;
import com.zhbit.service.MessageService;

/*
 * @author HuangLongChang
 */
public class PostDaoImpl implements PostDao {
	@Resource
	private SessionFactory sessionFactory;

	@Resource
	private MessageService messageService;

	@Override
	public void addPost(String aurthor, String content, int message_id) {
		// TODO Auto-generated method stub
		try {
			System.out.println("������������DAO����");
			Message message = messageService.selectMessageById(message_id);
			Post post = new Post();
			post.setAurthor(aurthor);

			post.setContent(content);

			post.setMessage(message);

			post.setContent(content);
			sessionFactory.getCurrentSession().save(post);

		} catch (Exception e) {
			System.out.println("�������ݳ���" + e);
		}

	}

	@Override
	public List<Post> selectAllPost(int messageId) {
		// TODO Auto-generated method stub
		System.out.println("�����������ID��ѯ��������DAO����IIIIIIIIIIIIIIIIIIIIIIIII");
		System.out.println(messageId);

		String hql = "from Post  where message_id=" + messageId
				+ " order by id desc ";
		List<Post> list = null;
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			list = query.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return list;

	}
}
