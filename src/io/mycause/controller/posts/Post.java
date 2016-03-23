package io.mycause.controller.posts;

public class Post {
	private String title;
	private String description;
	private int posterId;
	private int postId;
	private int postUpvotes;
	private int catId;
	private String imageLink;
	
	public int getCatId() {
		return catId;
	}
	
	public void setCatId(int catId) {
		this.catId = catId;
	}
	

	public void setImageLink(int catID) {
		switch (catId) {
		case 1:
			this.imageLink = "-piggy-bank";
			break;
		case 2:
			this.imageLink = "-time";
			break;
		case 3:
			this.imageLink = "-apple";
			break;
		case 4:
			this.imageLink = "-wrench";
			break;
		}
	}

	public String getImageLink() {
		return imageLink;
	}
	
	public int getPostUpvotes() {
		return postUpvotes;
	}

	public void setPostUpvotes(int postUpvotes) {
		this.postUpvotes = postUpvotes;
	}

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
