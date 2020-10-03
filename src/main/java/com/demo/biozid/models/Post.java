package com.demo.biozid.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "posts")
@Data
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 300)
	private String title;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Location location;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private User author;
	
	@Column(nullable = false)
	private Date createdAt = new Date();

	private Boolean marked = false;

}
