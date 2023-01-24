package com.masai.service;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.masai.DTO.PostDto;
import com.masai.exception.ResourceNotFundException;
import com.masai.model.Post;
import com.masai.model.User;
import com.masai.repo.PostDao;
import com.masai.repo.UserDao;

public class PostServiceImpl implements PostService{

	@Autowired
	private PostDao postDao;
	
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
		
		User user=this.userDao.findById(userId)
				.orElseThrow(()-> new ResourceNotFundException("User","id",userId));
		Post post=this.modelMapper.map(postDto, Post.class);
		post.setImageName("default.png");
		post.setAddDate(new Date());
		post.setUser(user);
		
		
		Post newPost=this.postDao.save(post);
		
		return this.modelMapper.map(newPost, PostDto.class);
	}

	@Override
	public Post updatePost(PostDto postDto, Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleePost(Integer postId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Post> getAllPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post getPostById(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getPostByUser(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> searchPost(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDto createPost(PostDto postDto, Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}
	


	
	
}
