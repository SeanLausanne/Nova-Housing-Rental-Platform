// Author: Xiao Ling

package com.dalhousie.university.novahousing.services.postSearch;

import com.dalhousie.university.novahousing.exception.FilterNotValidException;
import com.dalhousie.university.novahousing.model.post.House;
import com.dalhousie.university.novahousing.model.post.PropertyPost;
import com.dalhousie.university.novahousing.model.post.Post;
import com.dalhousie.university.novahousing.model.post.Property;
import com.dalhousie.university.novahousing.repository.post.PostPersistence;
import com.dalhousie.university.novahousing.services.filters.SearchFilter;
import com.dalhousie.university.novahousing.validations.postValidation.FilterListValidator;
import com.dalhousie.university.novahousing.validations.postValidation.FilterValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PropertyPostSearcher implements PostSearcher {

	@Autowired
	PostPersistence db;

	List<SearchFilter> filters;

	public PropertyPostSearcher() {
		filters = new ArrayList<>();
	}

	public void addFilter(SearchFilter filter) {
		filters.add(filter);
	}

	public List<SearchFilter> getFilters() {
		return filters;
	}

	public void clearFilters() {
		filters.clear();
	}

	@Override
	public List<Post> searchPost() throws FilterNotValidException {

		FilterListValidator filterListValidator = new FilterListValidator(filters);

		if (!filterListValidator.validate()) {
			throw new FilterNotValidException("Post filter list not valid");
		}

		for (SearchFilter filter : this.filters) {
			FilterValidator filterValidator = new FilterValidator(filter);
			if (!filterValidator.validate()) {
				throw new FilterNotValidException("Post filter not valid");
			}
		}

		
		// map database results to Post objects
		List<Map<String, Object>> results = db.searchPostInDatabase(filters);
		List<Post> posts = new ArrayList<>();

		for (Map<String, Object> row : results) {
			String id = String.valueOf(row.get("id"));
			String postDate = String.valueOf(row.get("postDate"));
			String type = String.valueOf(row.get("propertyType"));
			int area = (int) row.get("area");
			int bedroomNumber = (int) row.get("bedroomNumber");
			String adminApproved = String.valueOf("adminApproved");
			Double bathroomNumber = Double.valueOf(String.valueOf(row.get("bathroomNumber")));

			Property property;
			if (type.equals("House")) {
				property = new House.Builder().setArea(area).setBedroomNumber(bedroomNumber)
						.setBathroomNumber(bathroomNumber).build();
			} else if (type.equals("Apartment")) {
				property = new House.Builder().setArea(area).setBedroomNumber(bedroomNumber)
						.setBathroomNumber(bathroomNumber).build();
			} else {
				property = null;
			}

			Post post = new PropertyPost(property);
			post.setId(id);
			post.setPostDate(postDate);
			post.setAdminApproved(adminApproved);

			posts.add(post);
		}
		return posts;
	}

}
