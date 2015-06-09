package com.zhbit.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.zhbit.dao.MessageDao;
import com.zhbit.dao.UserDao;
import com.zhbit.domain.Message;

/*
 * @author HuangLongChang
 */
@Transactional
public class MessageServiceImpl implements MessageService{

	@Resource
	MessageDao messageDao;	
	
	@Override
	public List<Message> selectAllList() {
		// TODO Auto-generated method stub
		return messageDao.selectAllList();
	}

	@Override
	public void deleteMessage(int messageId) {
		// TODO Auto-generated method stub
		messageDao.deleteMessage(messageId);
		
	}

	@Override
	public void addMessage(String name, String title, String content) {
		// TODO Auto-generated method stub
		messageDao.addMessage(name,title,content);
	}

	@Override
	public Message selectMessageById(int id) {
		// TODO Auto-generated method stub
		return messageDao.selectMessageById(id);
	}

}
