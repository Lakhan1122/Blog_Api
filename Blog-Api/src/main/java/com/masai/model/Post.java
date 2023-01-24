package com.masai.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="posts")
@Getter
@Setter
@NoArgsConstructor
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer postId;
	
	@Column(name="post_title", length=100,nullable=false)
	private String title;
	
	
	@Column(length=10000)
	private String content;
	
	private String imageName;
	
	private Date addDate;
	
	
	@ManyToOne
	private User user;


	public void setAddDate(java.util.Date date) {
		// TODO Auto-generated method stub
		
	}

	
	
}
