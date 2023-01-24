package com.masai.service;

import java.util.List;

import com.masai.DTO.PostDto;
import com.masai.model.Post;

public interface PostService {

	
	PostDto createPost(PostDto postDto,Integer userId);
	
	
	Post updatePost(PostDto postDto,Integer postId);
	
	void deleePost(Integer postId);
	
	
	List<Post>  getAllPost();
	
	
	Post getPostById(Integer postId);
	
	List<Post> getPostByUser(Integer userId);
	
	List<Post>  searchPost(Integer userId);


	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
 }
