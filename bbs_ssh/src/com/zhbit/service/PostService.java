package com.zhbit.service;

import java.util.List;

import com.zhbit.domain.Post;

/*
 * @author HuangLongChang
 */
public interface PostService {
	public void addPost(String aurthor, String content, int message_id);

	public List<Post> selectAllPost(int MessageId);
}
