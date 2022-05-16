package com.dalhousie.university.novahousing.services.adminPostAction;
// Author- Anita Kumari (B00884141)

import com.dalhousie.university.novahousing.exception.AdminException;
import com.dalhousie.university.novahousing.exception.FilterNotValidException;
import com.dalhousie.university.novahousing.model.post.Post;

import java.util.List;

public interface AdminPostActionService {
    List<Post> getAllPostProperty() throws AdminException, FilterNotValidException;
    boolean approvePost(String id,String approveStatus) throws AdminException;
}
