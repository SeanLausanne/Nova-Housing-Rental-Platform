// Author: Xiao Ling

package com.dalhousie.university.novahousing;


import com.dalhousie.university.novahousing.exception.FilterNotValidException;
import com.dalhousie.university.novahousing.model.post.House;
import com.dalhousie.university.novahousing.model.post.PropertyPost;
import com.dalhousie.university.novahousing.model.post.Post;
import com.dalhousie.university.novahousing.model.post.Property;
import com.dalhousie.university.novahousing.repository.post.PostPersistence;
import com.dalhousie.university.novahousing.services.filters.BedroomFilter;
import com.dalhousie.university.novahousing.services.filters.SearchFilter;
import com.dalhousie.university.novahousing.services.filters.PropertyTypeFilter;
import com.dalhousie.university.novahousing.services.postSearch.PropertyPostSearcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class PostSearcherTest {
	
	@MockBean
	PostPersistence postPersistenceMock;

	@Autowired
    PropertyPostSearcher searcher;
	
	
	@Test
	public void checkFilterNotNull() {
		searcher = new PropertyPostSearcher();
		List<SearchFilter> filters = searcher.getFilters();
		assertEquals(0, filters.size());
	}
	
	@Test
	public void checkFilterNumber() {
		SearchFilter bedroomFilter = new BedroomFilter(-2);
		searcher = new PropertyPostSearcher();
		searcher.addFilter(bedroomFilter);
		Exception exception = assertThrows(FilterNotValidException.class, () -> searcher.searchPost());
		assertEquals("Post filter not valid", exception.getMessage());
	}
	
	
	@Test
	public void checkClearFilter() {
		SearchFilter bedroomFilter = new BedroomFilter(-2);
		searcher = new PropertyPostSearcher();
		searcher.addFilter(bedroomFilter);
		searcher.clearFilters();
		assertEquals(0, searcher.getFilters().size());
	}
	
	
	@Test
	public void checkFilterSize() {
		SearchFilter bedroomFilter = new BedroomFilter(-2);
		SearchFilter typeFilter = new PropertyTypeFilter("Apartment");
		searcher = new PropertyPostSearcher();
		searcher.addFilter(bedroomFilter);
		searcher.addFilter(typeFilter);
		List<SearchFilter> filters = searcher.getFilters();
		assertEquals(2, filters.size());

	}
	
	@Test
	public void checkFilterValue() {
		SearchFilter bedroomFilter = new BedroomFilter(-2);
		SearchFilter typeFilter = new PropertyTypeFilter("Apartment");
		searcher = new PropertyPostSearcher();
		searcher.addFilter(bedroomFilter);
		searcher.addFilter(typeFilter);
		List<SearchFilter> filters = searcher.getFilters();
		assertEquals("-2", filters.get(0).getFilterValue());
		assertEquals("Apartment", filters.get(1).getFilterValue());
	}
	
	@Test
	public void checkSearchResultsSize() {
		Map<String, Object> map = new HashMap<>();
				
		Property house = new House.Builder().setArea(100).setBedroomNumber(1).setBathroomNumber(1).build();
		
		Post post = new PropertyPost(house);
		post.setId("00000001");
		post.setPostDate("20211122");
		
		map.put("id", "00000001");
		map.put("postDate", "20211122");
		map.put("propertyType", "House");
		map.put("area", 100);
		map.put("bedroomNumber", 1);
		map.put("bathroomNumber", 1);
		
		List<Map<String, Object>> mockResults = new ArrayList<>();
		mockResults.add(map);
		
		List<SearchFilter> filters = searcher.getFilters();
		
		Mockito.when(postPersistenceMock.searchPostInDatabase(filters)).thenReturn(mockResults);
		
		try {
			List<Post> results = searcher.searchPost();			
			assertEquals(results.size(), 1);

		} catch (FilterNotValidException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void checkSearchResults() {
		
		// create mock results
		Map<String, Object> map = new HashMap<>();
		String id = "00000001";
		String postDate = "20211122";
		String type = "House";
		int area = 100;
		int bedroomNumber = 1;
		double bathroomNumber = 1;
		
		Property house = new House.Builder().setArea(area).setBedroomNumber(bedroomNumber).setBathroomNumber(bathroomNumber).build();
		
		Post post = new PropertyPost(house);
		post.setId(id);
		post.setPostDate(postDate);
		
		map.put("id", id);
		map.put("postDate", postDate);
		map.put("propertyType", type);
		map.put("area", area);
		map.put("bedroomNumber", bedroomNumber);
		map.put("bathroomNumber", bathroomNumber);
		
		List<Map<String, Object>> mockResults = new ArrayList<>();
		mockResults.add(map);
		
		List<SearchFilter> filters = searcher.getFilters();		
		
		Mockito.when(postPersistenceMock.searchPostInDatabase(filters)).thenReturn(mockResults);
		
		try {
			List<Post> results = searcher.searchPost();			
			Post resultPost = results.get(0);
			assertEquals(resultPost.getId(), id);
			assertEquals(resultPost.getPostDate(), postDate);
			Property resultProperty = resultPost.getProperty(); 
			assertEquals(resultProperty.getType(), type);
			assertEquals(resultProperty.getArea(), area);
			assertEquals(resultProperty.getBedroomNumber(), bedroomNumber);
			assertEquals(resultProperty.getBathroomNumber(), bathroomNumber);
		} catch (FilterNotValidException e) {
			e.printStackTrace();
		}
	}
	
}
