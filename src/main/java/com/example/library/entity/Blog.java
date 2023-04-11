package com.example.library.entity;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "Buhishta Xwendine Blogs")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Blog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "blog_author")
	private String blogAuthor;
	@Column(name = "blog_title")
	private String blogTitle;
	@Column(name = "blog_category")
	private String blogCategory;
	@Column(name = "book_publish_date")
	private Date blogPublishDate;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IMAGE_ID")
    Images image;
}
