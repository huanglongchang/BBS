package com.zhbit.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.domain.Message;
import com.zhbit.domain.Post;
import com.zhbit.service.PostService;

/*
 * @author HuangLongChang
 */
public class PostAction extends ActionSupport {

	@Resource
	private PostService postService;
	private static final long serialVersionUID = 1L;
	private Post post;
	private Message message;
	private int messageId;
	private String aurthor;
	private String content;
	private String name;

	public String addPost() {
		System.out.println("进入PostAction增加评论方法");
		postService.addPost(name,content,messageId);
		return "success" ;
	}
	
	public void selectAllPost() {
		HttpServletRequest request = ServletActionContext.getRequest();
		System.out.println("进入PostAction执行选择所有评论根据帖子ID");
	    List<Post> postList= postService.selectAllPost(messageId);
	    request.getSession(true).setAttribute("postList", postList);// 将登录用户存储至Session中
	    System.out.println("评论条目为"+postList.size());
	}

	public PostService getPostService() {
		return postService;
	}

	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getAurthor() {
		return aurthor;
	}

	public void setAurthor(String aurthor) {
		this.aurthor = aurthor;
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
	
	
}
