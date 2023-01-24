package com.masai.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Post;
import com.masai.model.User;

public interface PostDao extends JpaRepository<Post, Integer>{

	
	List<Post> findAllByUser(User user);
}
