// Author: Xiao Ling

package com.dalhousie.university.novahousing.services.postManagement;

import com.dalhousie.university.novahousing.exception.PostDatabaseUpdateException;
import com.dalhousie.university.novahousing.exception.PostInputNotValidException;
import com.dalhousie.university.novahousing.exception.PostNotFoundException;
import com.dalhousie.university.novahousing.model.post.Post;
import com.dalhousie.university.novahousing.model.post.Property;
import com.dalhousie.university.novahousing.repository.post.PostPersistence;
import com.dalhousie.university.novahousing.validations.postValidation.PostDbUpdateVlidator;
import com.dalhousie.university.novahousing.validations.postValidation.PostValidator;
import com.dalhousie.university.novahousing.validations.postValidation.PropertyValidator;
import com.dalhousie.university.novahousing.validations.postValidation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyPostManager implements PostManager {

	@Autowired
	PostPersistence db;

	@Override
	public void post(Post post) throws PostInputNotValidException, PostDatabaseUpdateException {

		Validator postValidator = new PostValidator(post);

		if (!postValidator.validate()) {
			throw new PostInputNotValidException("Post input not valid");
		}

		Property property = post.getProperty();
		Validator propertyValidator = new PropertyValidator(property);

		if (!propertyValidator.validate()) {
			throw new PostInputNotValidException("Property input not valid");
		}

		int update = db.savePostToDatabse(post);
		Validator postDbUpdateVlidator = new PostDbUpdateVlidator(update);

		if (!postDbUpdateVlidator.validate()) {
			throw new PostDatabaseUpdateException("Fail to add post");
		}
	}

	@Override
	public void removePost(Post post) throws PostNotFoundException {
		int update = db.removePostFromDatabase(post);
		Validator postDbUpdateVlidator = new PostDbUpdateVlidator(update);
		if (!postDbUpdateVlidator.validate()) {
			throw new PostNotFoundException("Post not found");
		}
	}

	@Override
	public void removePostByPostId(String postId) throws PostNotFoundException {
		int update = db.removePostFromDatabaseById(postId);
		Validator postDbUpdateVlidator = new PostDbUpdateVlidator(update);
		if (!postDbUpdateVlidator.validate()) {
			throw new PostNotFoundException("Post not found");
		}
	}

	@Override
	public void updatePost(Post post) throws PostInputNotValidException, PostDatabaseUpdateException {

		Validator postValidator = new PostValidator(post);

		if (!postValidator.validate()) {
			throw new PostInputNotValidException("Post input not valid");
		}

		Property property = post.getProperty();
		Validator propertyValidator = new PropertyValidator(property);

		if (!propertyValidator.validate()) {
			throw new PostInputNotValidException("Property input not valid");
		}

		int update = db.updatePostInDatabase(post);
		Validator postDbUpdateVlidator = new PostDbUpdateVlidator(update);
		if (!postDbUpdateVlidator.validate()) {
			throw new PostDatabaseUpdateException("Fail to update post");
		}
	}
}
