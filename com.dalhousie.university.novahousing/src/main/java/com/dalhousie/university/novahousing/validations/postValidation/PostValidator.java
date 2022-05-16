// Author: Xiao Ling

package com.dalhousie.university.novahousing.validations.postValidation;

import com.dalhousie.university.novahousing.model.post.Post;

public class PostValidator implements Validator {

	Post post;

	public PostValidator(Post post) {
		this.post = post;
	}

	@Override
	public boolean validate() {
		if (post == null) {
			return false;
		}

		String id = post.getId();
		String date = post.getPostDate();

		int month = Integer.valueOf(date.substring(4, 6));
		int day = Integer.valueOf(date.substring(6));

		if (date.length() != 8) {
			return false;
		}
		if (month <= 0 || month > 12) {
			return false;
		}
		if (day <= 0 || day > 31) {
			return false;
		}

		return true;
	}
}
