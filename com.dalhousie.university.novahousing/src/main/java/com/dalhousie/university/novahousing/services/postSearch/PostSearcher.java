// Author: Xiao Ling

package com.dalhousie.university.novahousing.services.postSearch;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dalhousie.university.novahousing.exception.FilterNotValidException;
import com.dalhousie.university.novahousing.model.post.Post;
import com.dalhousie.university.novahousing.services.filters.SearchFilter;

@Service
public interface PostSearcher {

	public void addFilter(SearchFilter filter);

	public List<SearchFilter> getFilters();

	public void clearFilters();

	public List<Post> searchPost() throws FilterNotValidException;

}
