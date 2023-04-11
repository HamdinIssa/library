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

@Entity
@Table(name = "Buhishta Xwendine Blogs")
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBlogAuthor() {
		return blogAuthor;
	}

	public void setBlogAuthor(String blogAuthor) {
		this.blogAuthor = blogAuthor;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getBlogCategory() {
		return blogCategory;
	}

	public void setBlogCategory(String blogCategory) {
		this.blogCategory = blogCategory;
	}

	public Date getBlogPublishDate() {
		return blogPublishDate;
	}

	public void setBlogPublishDate(Date blogPublishDate) {
		this.blogPublishDate = blogPublishDate;
	}

}
