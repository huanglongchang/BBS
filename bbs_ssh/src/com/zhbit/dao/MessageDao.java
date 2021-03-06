package com.zhbit.dao;

import java.util.List;

import com.zhbit.domain.Message;

/*
 * @author HuangLongChang
 */
public interface MessageDao {
	public List<Message> selectAllList();

	public void deleteMessage(int messageId);

	public void addMessage(String name, String title, String content);

	public Message selectMessageById(int id);
	
	
	
}
