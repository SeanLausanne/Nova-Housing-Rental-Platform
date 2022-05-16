// Author: Xiao Ling

package com.dalhousie.university.novahousing.model.post;

public abstract class Post {

	String id;
	Property property;
	String postDate;
	String adminApproved;

	public Post(Property property) {
		this.property = property;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public String getPostDate() {
		return this.postDate;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public void setAdminApproved(String adminApproved) {
		this.adminApproved = adminApproved;
	}

	public String getAdminApproved() {
		return adminApproved;
	}
}
