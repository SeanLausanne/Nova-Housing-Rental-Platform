package com.dalhousie.university.novahousing.controller.dto;

// Author- Anita Kumari (B00884141)

import com.dalhousie.university.novahousing.model.post.Property;
import com.dalhousie.university.novahousing.utils.TimeGenerator;

public class PostDto {
    private String id;
    private Property property;
    private String postDate;
    private String adminApproved;

    public PostDto (Property property) {
    	TimeGenerator timeGenerator = new TimeGenerator();
        this.id = timeGenerator.generateCurrentTimeMillisecond();
        this.property = property;
        adminApproved = "No";
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
