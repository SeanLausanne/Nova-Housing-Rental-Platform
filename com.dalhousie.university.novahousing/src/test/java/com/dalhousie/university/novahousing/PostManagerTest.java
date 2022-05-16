// Author: Xiao Ling

package com.dalhousie.university.novahousing;

import com.dalhousie.university.novahousing.exception.PostDatabaseUpdateException;
import com.dalhousie.university.novahousing.exception.PostInputNotValidException;
import com.dalhousie.university.novahousing.exception.PostNotFoundException;
import com.dalhousie.university.novahousing.model.post.House;
import com.dalhousie.university.novahousing.model.post.PropertyPost;
import com.dalhousie.university.novahousing.model.post.Post;
import com.dalhousie.university.novahousing.model.post.Property;
import com.dalhousie.university.novahousing.repository.post.PostDatabase;
import com.dalhousie.university.novahousing.services.postManagement.PropertyPostManager;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest

public class PostManagerTest {

//	Property house;
//	Post post;
	
	@MockBean
	PostDatabase postDatabaseMock;

	@Autowired
    PropertyPostManager postManager;
	
	// ------------------ test post -------------------
	
	@Test
	public void checkPostInputNullPost() {
		Exception exception = assertThrows(PostInputNotValidException.class, () -> postManager.post(null));
		assertEquals("Post input not valid", exception.getMessage());
	}
	
	@Test
	public void checkPostInputPostDateDigitNumber() {
		
		Property house = new House.Builder().setArea(1).setBedroomNumber(1).setBathroomNumber(1).build();
		Post post = new PropertyPost(house);
		
		post.setPostDate("202111221");
		Exception exception = assertThrows(PostInputNotValidException.class, () -> postManager.post(post));
		assertEquals("Post input not valid", exception.getMessage());
	}
	
	@Test
	public void checkPostInputPostDateMonth() {
		
		Property house = new House.Builder().setArea(1).setBedroomNumber(1).setBathroomNumber(1).build();
		Post post = new PropertyPost(house);
		
		post.setPostDate("20211322");
		Exception exception = assertThrows(PostInputNotValidException.class, () -> postManager.post(post));
		assertEquals("Post input not valid", exception.getMessage());
	}
	
	@Test
	public void checkPostInputPostDateDay() {
		
		Property house = new House.Builder().setArea(1).setBedroomNumber(1).setBathroomNumber(1).build();
		Post post = new PropertyPost(house);

		post.setPostDate("20211232");
		Exception exception = assertThrows(PostInputNotValidException.class, () -> postManager.post(post));
		assertEquals("Post input not valid", exception.getMessage());
	}
	

	@Test
	public void checkPostInputPropertyArea() {

		Property house = new House.Builder().setArea(-1).setBedroomNumber(1).setBathroomNumber(1).build();
		Post post = new PropertyPost(house);
		post.setPostDate("20211122");	
		Exception exception = assertThrows(PostInputNotValidException.class, () -> postManager.post(post));
		assertEquals("Property input not valid", exception.getMessage());
	}
	
	@Test
	public void checkPostInputNullProperty() {
		Post post = new PropertyPost(null);
		post.setPostDate("20211122");
		System.out.println(post.getProperty());
		Exception exception = assertThrows(PostInputNotValidException.class, () -> postManager.post(post));
		assertEquals("Property input not valid", exception.getMessage());
	}
	
	@Test
	public void checkPostInputPropertyBedroomNumber() {
		Property house = new House.Builder().setArea(1).setBedroomNumber(-1).setBathroomNumber(1).build();
		Post post = new PropertyPost(house);
		post.setPostDate("20211122");
		Exception exception = assertThrows(PostInputNotValidException.class, () -> postManager.post(post));
		assertEquals("Property input not valid", exception.getMessage());
	}

	@Test
	public void checkPostInputPropertyBathroomNumberNegative() {
		Property house = new House.Builder().setArea(1).setBedroomNumber(1).setBathroomNumber(-1).build();
		Post post = new PropertyPost(house);
		post.setPostDate("20211122");
		Exception exception = assertThrows(PostInputNotValidException.class, () -> postManager.post(post));
		assertEquals("Property input not valid", exception.getMessage());

	}
	
	@Test
	public void checkPostInputPropertyBathroomNumberDecimal() {
		Property house = new House.Builder().setArea(1).setBedroomNumber(1).setBathroomNumber(1.1).build();
		Post post2 = new PropertyPost(house);
		post2.setPostDate("20211122");
		Exception exception = assertThrows(PostInputNotValidException.class, () -> postManager.post(post2));
		assertEquals("Property input not valid", exception.getMessage());
	}
	
	@Test
	public void checkAddPostFailure() {
		Property house = new House.Builder().setArea(1).setBedroomNumber(1).setBathroomNumber(1).build();
		Post post = new PropertyPost(house);
		post.setPostDate("20211122");
		Mockito.when(postDatabaseMock.savePostToDatabse(post)).thenReturn(0);
		Exception exception = assertThrows(PostDatabaseUpdateException.class, () -> postManager.post(post));
		assertEquals("Fail to add post", exception.getMessage());
	}
	
	// ------------------ test remove -------------------
	
	@Test
	public void checkRemoveNullPost() {
		Mockito.when(postDatabaseMock.removePostFromDatabase(null)).thenReturn(0);
		Exception exception = assertThrows(PostNotFoundException.class, () -> postManager.removePost(null));
		assertEquals("Post not found", exception.getMessage());
	}
	
	@Test
	public void checkRemoveNotExistingPost() {
		Property house = new House.Builder().setArea(1).setBedroomNumber(1).setBathroomNumber(1).build();
		Post post = new PropertyPost(house);
		Mockito.when(postDatabaseMock.removePostFromDatabase(post)).thenReturn(0);
		Exception exception = assertThrows(PostNotFoundException.class, () -> postManager.removePost(post));
		assertEquals("Post not found", exception.getMessage());
	}
	
	@Test
	public void checkRemoveNullId() {
		Mockito.when(postDatabaseMock.removePostFromDatabaseById(null)).thenReturn(0);
		Exception exception = assertThrows(PostNotFoundException.class, () -> postManager.removePostByPostId(null));
		assertEquals("Post not found", exception.getMessage());
	}
	
	@Test
	public void checkRemoveNotExistingId() {
		String postId = "00000000";
		Mockito.when(postDatabaseMock.removePostFromDatabaseById(postId)).thenReturn(0);
		Exception exception = assertThrows(PostNotFoundException.class, () -> postManager.removePostByPostId(postId));
		assertEquals("Post not found", exception.getMessage());
	}
	
	// ------------------ test update -------------------
	
	@Test
	public void checkUpdateInputNullPost() {
		Exception exception = assertThrows(PostInputNotValidException.class, () -> postManager.updatePost(null));
		assertEquals("Post input not valid", exception.getMessage());
	}
	
	@Test
	public void checkUpdateInputPostDateNumberDigit() {
		Property house = new House.Builder().setArea(1).setBedroomNumber(1).setBathroomNumber(1).build();
		Post post = new PropertyPost(house);
		
		post.setPostDate("202111221");
		Exception exception = assertThrows(PostInputNotValidException.class, () -> postManager.updatePost(post));
		assertEquals("Post input not valid", exception.getMessage());
		
	}
	
	@Test
	public void checkUpdateInputPostDateMonth() {
		Property house = new House.Builder().setArea(1).setBedroomNumber(1).setBathroomNumber(1).build();
		Post post = new PropertyPost(house);
		
		post.setPostDate("20211322");
		Exception exception = assertThrows(PostInputNotValidException.class, () -> postManager.updatePost(post));
		assertEquals("Post input not valid", exception.getMessage());
	}
	
	
	@Test
	public void checkUpdateInputPostDateDay() {
		Property house = new House.Builder().setArea(1).setBedroomNumber(1).setBathroomNumber(1).build();
		Post post = new PropertyPost(house);
		
		post.setPostDate("20211232");
		Exception exception = assertThrows(PostInputNotValidException.class, () -> postManager.updatePost(post));
		assertEquals("Post input not valid", exception.getMessage());
	}

	@Test
	public void checkUpdateInputPropertyArea(){
		Property house = new House.Builder().setArea(-1).setBedroomNumber(1).setBathroomNumber(1).build();
		Post post = new PropertyPost(house);
		post.setPostDate("20211122");
		Exception exception = assertThrows(PostInputNotValidException.class, () -> postManager.updatePost(post));
		assertEquals("Property input not valid", exception.getMessage());
	}
	
	@Test
	public void checkInputNullProperty() {
		PropertyPost post = new PropertyPost(null);
		post.setPostDate("20211122");
		Exception exception = assertThrows(PostInputNotValidException.class, () -> postManager.updatePost(post));
		assertEquals("Property input not valid", exception.getMessage());
	}
	

	@Test
	public void checkInputPropertyBedroomNumber() {
		Property house = new House.Builder().setArea(1).setBedroomNumber(-1).setBathroomNumber(1).build();
		Post post = new PropertyPost(house);
		post.setPostDate("20211122");
		Exception exception = assertThrows(PostInputNotValidException.class, () -> postManager.updatePost(post));
		assertEquals("Property input not valid", exception.getMessage());
	}

	@Test
	public void checkUpdateInputPropertyBathroomNumberNegative() {
		Property house = new House.Builder().setArea(1).setBedroomNumber(1).setBathroomNumber(-1).build();
		PropertyPost post = new PropertyPost(house);
		post.setPostDate("20211122");
		
		Exception exception = assertThrows(PostInputNotValidException.class, () -> postManager.updatePost(post));
		assertEquals("Property input not valid", exception.getMessage());
	}
	
	@Test
	public void checkUpdateInputPropertyBathroomNumberDecimal() {
		Property house = new House.Builder().setArea(1).setBedroomNumber(1).setBathroomNumber(1.1).build();
		PropertyPost post2 = new PropertyPost(house);
		post2.setPostDate("20211122");
		Exception exception = assertThrows(PostInputNotValidException.class, () -> postManager.updatePost(post2));
		assertEquals("Property input not valid", exception.getMessage());
	}
	
	
	@Test
	public void checkUpdatePostFailure() {
		Property house = new House.Builder().setArea(1).setBedroomNumber(1).setBathroomNumber(1).build();
		Post post = new PropertyPost(house);
		post.setPostDate("20211122");
		Mockito.when(postDatabaseMock.updatePostInDatabase(post)).thenReturn(0);
		Exception exception = assertThrows(PostDatabaseUpdateException.class, () -> postManager.updatePost(post));
		assertEquals("Fail to update post", exception.getMessage());
	}
}
