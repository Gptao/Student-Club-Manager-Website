package com.nankai.app.domain;

public class Chatroom {
	private int messageId;
	private int messageAuthor;
	private String messageContent;
	private String messageTime;
	private String messageMail;
	private int tag;
	public String getMessageTime() {
		return messageTime;
	}
	public void setMessageTime(String messageTime) {
		this.messageTime = messageTime;
	}
	public int getMessageId() {
		return messageId;
	}
	public String getMessageMail() {
		return messageMail;
	}
	public void setMessageMail(String messageMail) {
		this.messageMail = messageMail;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public int getMessageAuthor() {
		return messageAuthor;
	}
	public void setMessageAuthor(int messageAuthor) {
		this.messageAuthor = messageAuthor;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public int getTag() {
		return tag;
	}
	public void setTag(int tag) {
		this.tag = tag;
	}
}
