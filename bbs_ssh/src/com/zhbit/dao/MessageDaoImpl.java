package com.zhbit.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import com.zhbit.domain.Message;

/*
 * @author HuangLongChang
 */
public class MessageDaoImpl implements MessageDao {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public List<Message> selectAllList() {
		// TODO Auto-generated method stub
		String hql = "from Message order by id desc";
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(hql);
		System.out.println("进入查询返回所有帖子列表");
		System.out.println("+++++++++++++++++++++++++++++");
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println("+++++++++++++++++++++++++++++=");
		List<Message> list = query.list();
		if (list == null) {

			System.out.println("DAO查空");
		}
		if (list != null) {

			System.out.println("DAO不等于空");
		}
		return list;
	}

	@Override
	public void deleteMessage(int messageId) {
		// TODO Auto-generated method stub
		System.out.println("进入删除帖子DAO");
		try {
			// Query query =
			// sessionFactory.getCurrentSession().createQuery(hql);

			Message message = (Message) sessionFactory.getCurrentSession()
					.load(Message.class, messageId);
			sessionFactory.getCurrentSession().delete(message);
		} catch (Exception e) {
			System.out.println("删除数据出错：" + e);
		}

	}

	@Override
	public void addMessage(String name, String title, String content) {
		// TODO Auto-generated method stub
		try {

			Message message = new Message();
			message.setAurthor(name);
			message.setTitle(title);
			message.setContent(content);

			sessionFactory.getCurrentSession().save(message);

		} catch (Exception e) {
			System.out.println("插入数据出错：" + e);
		}
	}

	@Override
	public Message selectMessageById(int id) {
		// TODO Auto-generated method stub
		Message message = null;
		// String hql = "from Users where name=test1 and password=test1";

		try {
			String hql = "from Message where id='" + id + "'";
			System.out.println(hql);
			System.out.println("进入根据ID查询帖子DAO方法");

			/*
			 * if(session==null) { System.out.println("jb1"); }
			 */

			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			if (query.uniqueResult() != null) {
				System.out.println("进入根据ID查询帖子DAO方法，有结果");
				message = (Message) query.uniqueResult();

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("返回结果");
		return message;
	}

}
