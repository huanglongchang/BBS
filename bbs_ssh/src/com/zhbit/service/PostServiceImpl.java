package com.zhbit.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.zhbit.dao.MessageDao;
import com.zhbit.dao.PostDao;
import com.zhbit.domain.Post;

/*
 * @author HuangLongChang
 */
@Transactional
public class PostServiceImpl implements PostService {
	@Resource
	PostDao postDao;

	@Override
	public void addPost(String aurthor, String content, int message_id) {
		// TODO Auto-generated method stub
		postDao.addPost(aurthor, content, message_id);
	}

	@Override
	public List<Post> selectAllPost(int MessageId) {
		// TODO Auto-generated method stub
		return postDao.selectAllPost(MessageId);
	}

}
