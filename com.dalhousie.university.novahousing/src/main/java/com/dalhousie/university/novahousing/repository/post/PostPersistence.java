// Author: Xiao Ling

package com.dalhousie.university.novahousing.repository.post;

import com.dalhousie.university.novahousing.model.post.Post;
import com.dalhousie.university.novahousing.services.filters.SearchFilter;

import java.util.List;
import java.util.Map;

public interface PostPersistence {
	
	public int savePostToDatabse(Post post);

	public int removePostFromDatabase(Post post);

	public int removePostFromDatabaseById(String id);

	public int updatePostInDatabase(Post post);

	public List<Map<String, Object>> searchPostInDatabase(List<SearchFilter> filters);

}
