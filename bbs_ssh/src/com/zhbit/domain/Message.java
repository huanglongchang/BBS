package com.zhbit.domain;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Message entity. @author MyEclipse Persistence Tools
 */

public class Message implements java.io.Serializable {

	// Fields

	private Integer id;
	private String aurthor;
	private String title;
	private String content;
	private Timestamp newDate;
	private Set posts = new HashSet(0);

	// Constructors

	/** default constructor */
	public Message() {
	}

	/** full constructor */
	public Message(String aurthor, String title, String content,
			Timestamp newDate, Set posts) {
		this.aurthor = aurthor;
		this.title = title;
		this.content = content;
		this.newDate = newDate;
		this.posts = posts;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAurthor() {
		return this.aurthor;
	}

	public void setAurthor(String aurthor) {
		this.aurthor = aurthor;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getNewDate() {
		return this.newDate;
	}

	public void setNewDate(Timestamp newDate) {
		this.newDate = newDate;
	}

	public Set getPosts() {
		return this.posts;
	}

	public void setPosts(Set posts) {
		this.posts = posts;
	}

}