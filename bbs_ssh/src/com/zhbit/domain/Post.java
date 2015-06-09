package com.zhbit.domain;

import java.sql.Timestamp;

/**
 * Post entity. @author MyEclipse Persistence Tools
 */

public class Post implements java.io.Serializable {

	// Fields

	private Integer id;
	private Message message;
	private String aurthor;
	private String content;
	private Timestamp newDate;

	// Constructors

	/** default constructor */
	public Post() {
	}

	/** full constructor */
	public Post(Message message, String aurthor, String content,
			Timestamp newDate) {
		this.message = message;
		this.aurthor = aurthor;
		this.content = content;
		this.newDate = newDate;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Message getMessage() {
		return this.message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public String getAurthor() {
		return this.aurthor;
	}

	public void setAurthor(String aurthor) {
		this.aurthor = aurthor;
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

}