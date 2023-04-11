package com.example.library.entity;

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
@Table(name = "Buhishta Xwendine Images")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Images {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IMAGE_ID")
	private int id;

	@Column(name = "IMAGE_NAME")
	private String imageName;

	@OneToOne(mappedBy= "image", cascade =CascadeType.ALL)
	@JoinColumn(name = "IMAGE_NAME")
	private Book book;



}