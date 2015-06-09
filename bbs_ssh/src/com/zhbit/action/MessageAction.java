package com.zhbit.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.domain.Message;
import com.zhbit.service.MessageService;
import com.zhbit.service.UserService;

/*
 * @author HuangLongChang
 */
public class MessageAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Message message;
    private int messageId;
    private String title;
	private String content;
	private String name;
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getMessageId() {
		return messageId;
	}


	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	@Resource
	private MessageService messageService;
	public void selectMessageById(){
		
		System.out.println("=============================");
		System.out.println(messageId);
		System.out.println("�������IDѰ������Action");
	   
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("message", messageService.selectMessageById(messageId));// ����¼�û��洢��Session��
	}
	
	
	
public String deleteMessage(){
		
		System.out.println("=============================");
		System.out.println("����ɾ������Action");
		messageService.deleteMessage(messageId);
		return "success";
	}
public String addMessage(){
	
	System.out.println("=============================");
	System.out.println("����ɾ������Action");
	messageService.addMessage(name,title,content);
	return "success";
}


	
	public void selectAllList() {
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Message> messageList = null;
		System.out.printf("DDDDDDDDDDDDDDDDDDDDDDDDD");
		messageList = (List<Message>) messageService.selectAllList();
		if (messageList.get(0) == null) {
			System.out.println("D���");
		}
		request.getSession(true).setAttribute("messageList", messageList);// ����¼�û��洢��Session��

	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public MessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

}
