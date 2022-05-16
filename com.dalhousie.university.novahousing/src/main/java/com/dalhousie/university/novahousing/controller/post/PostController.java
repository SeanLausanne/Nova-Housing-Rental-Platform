//Author: Xiao Ling

package com.dalhousie.university.novahousing.controller.post;

import com.dalhousie.university.novahousing.exception.PostDatabaseUpdateException;
import com.dalhousie.university.novahousing.exception.PostInputNotValidException;
import com.dalhousie.university.novahousing.model.post.Apartment;
import com.dalhousie.university.novahousing.model.post.House;
import com.dalhousie.university.novahousing.model.post.PropertyPost;
import com.dalhousie.university.novahousing.model.post.Post;
import com.dalhousie.university.novahousing.model.post.Property;
import com.dalhousie.university.novahousing.services.filters.*;
import com.dalhousie.university.novahousing.services.postManagement.PostManager;
import com.dalhousie.university.novahousing.services.postSearch.PostSearcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

// Because I didn't create UI for demo, I hard coded the test scenarios for demo video to mimic user behaviors in this controller class.
// With proper UI, this controller will only receive input values and pass to service classes.

@Controller
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostManager manager;

	@Autowired
	private PostSearcher search;

	List<Post> posts = new ArrayList<>();

	@GetMapping("/")
	public String generatePostForm(Model model) {
		return "postForm";
	}

	// mimic user input on webpage
	@GetMapping("/inputpost")
	public String inputPost(Model modelPost) throws InterruptedException {
		Property house1 = new House.Builder().setArea(100).setBedroomNumber(1).setBathroomNumber(1.5).build();
		Post postHouse1 = new PropertyPost(house1);
		postHouse1.setPostDate("20211123");
		posts.add(postHouse1);
		TimeUnit.MICROSECONDS.sleep(5);

		Property house2 = new House.Builder().setArea(150).setBedroomNumber(2).setBathroomNumber(2).build();
		Post postHouse2 = new PropertyPost(house2);
		postHouse2.setPostDate("20211124");
		posts.add(postHouse2);
		TimeUnit.MICROSECONDS.sleep(5);

		Property apartment1 = new Apartment.Builder().setArea(50).setBedroomNumber(1).setBathroomNumber(1).build();
		Post postApartment1 = new PropertyPost(apartment1);
		postApartment1.setPostDate("20211125");
		posts.add(postApartment1);
		TimeUnit.MICROSECONDS.sleep(5);

		StringBuilder output = new StringBuilder();
		output.append("posts created:\n");
		for (Post post : posts) {
			Property property = post.getProperty();
			output.append("Post id: " + post.getId() + ", Post date: " + post.getPostDate());
			output.append(", Property type: " + property.getType() + ", Area: " + property.getArea());
			output.append(", Bedroom Number: " + property.getBedroomNumber() + ", Bathroom Number: "
					+ property.getBathroomNumber());
			output.append("\n");
		}
		System.out.println(output.toString());

		modelPost.addAttribute("stringToDisplay", output);

		return "postcreatedsuccessfully";
	}

	// mimic user save post
	@GetMapping("/savepost")
	public String savePost(Model modelPost) {
		try {
			for (Post post : posts) {
				this.manager.post(post);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		StringBuilder output = new StringBuilder();
		output.append("posts saved:\n");
		for (Post post : posts) {
			Property property = post.getProperty();
			output.append("Post id: " + post.getId() + ", Post date:" + post.getPostDate());
			output.append(", Property type: " + property.getType() + ", Area: " + property.getArea());
			output.append(", Bedroom Number: " + property.getBedroomNumber() + ", Bathroom Number: "
					+ property.getBathroomNumber());
			output.append(", Approved by admin: " + post.getAdminApproved() + "\n");
		}
		System.out.println(output.toString());
		modelPost.addAttribute("stringToDisplay", output);
		return "postcreatedsuccessfully";
	}

	// mimic user update post
	@GetMapping("/updatepost")
	public String updatePost(Model modelPost) throws InterruptedException {
		Post post = posts.get(0);
		String postId = post.getId();
		Property property = post.getProperty();
		Property updatedProperty = new Apartment.Builder().setArea(100).setBedroomNumber(1).setBathroomNumber(1.5)
				.build();
		Post updatedPost = new PropertyPost(updatedProperty);
		updatedPost.setId(postId);
		updatedPost.setPostDate("20221126");

		try {
			manager.updatePost(updatedPost);
		} catch (PostInputNotValidException | PostDatabaseUpdateException e) {
			e.printStackTrace();
		}

		StringBuilder output = new StringBuilder();
		output.append("Old post: \n");
		output.append("Post id: " + post.getId() + ", Post date: " + post.getPostDate());
		output.append(", Property type: " + property.getType() + ", Area: " + property.getArea());
		output.append(", Bedroom Number: " + property.getBedroomNumber() + ", Bathroom Number:"
				+ property.getBathroomNumber());
		output.append(", Approved by admin: " + post.getAdminApproved() + "\n");

		output.append("new Post: \n");
		output.append("Post id: " + updatedPost.getId() + ", Post date: " + updatedPost.getPostDate());
		output.append(", Property type: " + updatedProperty.getType() + ", Area: " + updatedProperty.getArea());
		output.append(", Bedroom Number: " + updatedProperty.getBedroomNumber() + ", Bathroom Number: "
				+ updatedProperty.getBathroomNumber());
		output.append(", Approved by admin: " + post.getAdminApproved() + "\n");
		System.out.println(output);

		modelPost.addAttribute("stringToDisplay", output);
		return "postcreatedsuccessfully";
	}

	// mimic user delete post
	@GetMapping("/deletepost")
	public String removePost(Model modelPost) {

		Post post = posts.get(posts.size() - 1);
		posts.remove(posts.size() - 1);
		String postId = post.getId();

		try {
			this.manager.removePostByPostId(postId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Post removed:" + post.getId());

		modelPost.addAttribute("stringToDisplay", "Post removed:" + post.getId());
		return "postcreatedsuccessfully";
	}

	// mimic user search post
	@GetMapping("/searchpost")
	public String searchPost(Model modelPost) {

		List<SearchFilter> filters = new ArrayList<>();
		SearchFilter bedroomFilter = new BedroomFilter(2);
		filters.add(bedroomFilter);
		SearchFilter bathroomFilter = new BathroomFilter(2);
		filters.add(bathroomFilter);
		SearchFilter typeFilter = new PropertyTypeFilter("\"House\"");
		filters.add(typeFilter);
		SearchFilter adminFilter = new AdminApprovalFilter("\"No\"");
		filters.add(adminFilter);

		StringBuilder output = new StringBuilder();
		output.append("Apply filter: \n");
		for (SearchFilter filter : filters) {
			search.addFilter(filter);
			output.append(filter.getFilterCategory() + ": " + filter.getFilterValue() + ", ");
		}

		try {
			List<Post> results = this.search.searchPost();

			output.append("posts found:\n");
			for (Post post : results) {
				Property property = post.getProperty();
				output.append("Post id: " + post.getId() + ", Post date:" + post.getPostDate());
				output.append(", Property type: " + property.getType() + ", Area: " + property.getArea());
				output.append(", Bedroom Number:" + property.getBedroomNumber() + ", Bathroom Number:"
						+ property.getBathroomNumber());
				output.append(", Approved by admin: " + post.getAdminApproved() + "\n");
			}

			System.out.println(output.toString());
			modelPost.addAttribute("stringToDisplay", output);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "postcreatedsuccessfully";
	}
};
