package io.mycause.controller;

public class Post {
	private String title;
	private String description;
	private int posterId;
	private int postId;
	
	public Post() {
		
	}
	
	public Post(String mTitle, String mDescription) {
		title = mTitle;
		description = mDescription;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String mTitle) {
		title = mTitle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String mDescription) {
		description = mDescription;
	}
	public int getPosterId() {
		return posterId;
	}
	public void setPosterId(int mPosterId) {
		posterId = mPosterId;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int mPostId) {
		postId = mPostId;
	}
	
}
