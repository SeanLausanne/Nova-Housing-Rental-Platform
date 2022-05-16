// Author: Xiao Ling

package com.dalhousie.university.novahousing.services.postManagement;

import org.springframework.stereotype.Service;

import com.dalhousie.university.novahousing.exception.PostDatabaseUpdateException;
import com.dalhousie.university.novahousing.exception.PostInputNotValidException;
import com.dalhousie.university.novahousing.exception.PostNotFoundException;
import com.dalhousie.university.novahousing.model.post.Post;


@Service
public interface PostManager {

	public void post(Post post) throws PostInputNotValidException, PostDatabaseUpdateException;

	public void removePost(Post post) throws PostNotFoundException;

	public void removePostByPostId(String postId) throws PostNotFoundException;

	public void updatePost(Post post) throws PostInputNotValidException, PostDatabaseUpdateException;

}
